import * as React from 'react';
import Box from '@mui/material/Box';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import './list.styles.css';
// import axios from 'axios';
// import TextField from '@mui/material/TextField';
import InputLabel from '@mui/material/InputLabel';
import { getTeams } from '../../../services/team';

interface Team {
  teamId: string;
  teamName: string;
}
 
export default function BasicSelect() {
  const [team, setTeam] = React.useState('');
  const [teamsData, setTeamsData] = React.useState<Team[]>([]);
 
 
  React.useEffect(() => {
    getTeams()  
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
      <div className='select'>
        <FormControl className='select' sx={{ m: 2, minWidth: 450 }}>

        <InputLabel id="team_questions"
          sx={{
            left: '-3px',  
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
      </div>
    </Box >
  );


}

/*{currencies.map((option) => (
          <MenuItem key={option.value} value={option.value}>
            {option.label}
          </MenuItem>


           <Select
        labelId="team_questions"
        id="demo-simple-select"
        placeholder='Select your team'
        value={team}
        label='My team is'
        onChange={handleChange}
      >
        <MenuItem value={10}>SQA</MenuItem>
        <MenuItem value={20}>TIWH</MenuItem>
        <MenuItem value={30}>Midas</MenuItem>
      </Select>
        ))}*/