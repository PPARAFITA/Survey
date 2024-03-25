import * as React from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import axios from 'axios';

interface Team {
  teamId: string;
  teamName: string;
}


const username = 'user';
const password = '7f57edd8-3589-48e9-beb0-f882da413aeb';
const credentials = btoa(`${username}:${password}`);

export default function BasicSelect() {
  const [team, setTeam] = React.useState('');
  const [teamsData, setTeamsData] = React.useState<Team[]>([]);


  React.useEffect(() => {
    axios.get('/api/v1/thermometer/team', {
      headers: {
        'Authorization': `Basic ${credentials}`
      }
    })
      .then(response => {
        console.log(response.data);
        setTeamsData(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);


  const handleChange = (event: SelectChangeEvent) => {
    const selectedTeamId = event.target.value as string;
    const selectedTeam = teamsData.find(team => team.teamId === selectedTeamId);
    console.log("Selected team:", selectedTeamId);
    console.log("Selected team:", selectedTeam);
    console.log(selectedTeam?.teamName);
    
    if (selectedTeam) {
      setTeam(selectedTeam.teamId);
    }
  };

  return (
    <Box sx={{ minWidth: 450 }}>
      <FormControl sx={{ m: 2, minWidth: 450 }}>
        <InputLabel id="team_questions"
          sx={{
            left: '-3px', // Ajuste fino para mover la etiqueta dentro del borde
            top: '-6px',


          }}>My team is </InputLabel>
        <Select
          labelId="team_questions"
          id="demo-simple-select"
          placeholder='Select your team'
          value={team}
          label="Team"
          onChange={handleChange}
        >
           {teamsData.map((teamItem: any) => (
            <MenuItem key={teamItem.teamId} value={teamItem.teamId}>{teamItem.teamName}</MenuItem>
          ))}
        </Select>
      </FormControl>
    </Box>
  );
}