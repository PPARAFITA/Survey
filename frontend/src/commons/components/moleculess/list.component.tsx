import * as React from 'react';
import Box from '@mui/material/Box';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import './list.styles.css';
import InputLabel from '@mui/material/InputLabel';
import { getTeams } from '../../../services/team';

interface Team {
  teamId: string;
  teamName: string;
}

interface BasicSelect {
  onTeamSelect: (teamId: string) => void;
}


 export default function BasicSelect  ({ onTeamSelect }: BasicSelect){
  console.log('Componente LIST renderizado')

  const [team, setTeam] = React.useState('');
  const [teamsData, setTeamsData] = React.useState<Team[]>([]);

  React.useEffect(() => {
    getTeams()
      .then(response => { 
        setTeamsData(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  

  const handleChange = (event: SelectChangeEvent) => {
    const selectedTeamId = event.target.value as string;
    const selectedTeam = teamsData.find(team => team.teamId === selectedTeamId);

    console.log(selectedTeam?.teamName);

    if (selectedTeam) {
      setTeam(selectedTeam.teamId);
      onTeamSelect(selectedTeam.teamId);  
    }
  };

  return (
    <Box sx={{ minWidth: 450 }}>
      <div className='select'>
        <FormControl className='select' sx={{ m: 2, minWidth: 450 }}>

        <InputLabel id="team_questions"
          sx={{
            left: '-3px',
            top: '-6px',


          }}>My team is </InputLabel>
        <Select
          labelId="team_questions"
          id="select_team"
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
      </div>
    </Box >
  );
}
