import * as React from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';

export default function BasicSelect() {
  const [team, setTeam] = React.useState('');

  const handleChange = (event: SelectChangeEvent) => {
    setTeam(event.target.value as string);
  };

  return (
    <Box sx={{ minWidth: 450 }}>
      <FormControl   sx={{ m: 2, minWidth: 450 }}>
        <InputLabel id="team_questions" 
        sx={{ 
            left: '-3px', // Ajuste fino para mover la etiqueta dentro del borde
            top:'-6px',
      
        
      }}>My team is </InputLabel>
        <Select
          labelId="team_questions"
          id="demo-simple-select"
          placeholder='Select your team'
          value={team}
          label="Team"
          onChange={handleChange}
        >
          <MenuItem value={10}>SQA</MenuItem>
          <MenuItem value={20}>TIWH</MenuItem>
          <MenuItem value={30}>Midas</MenuItem>
        </Select>
      </FormControl>
    </Box>
  );
}