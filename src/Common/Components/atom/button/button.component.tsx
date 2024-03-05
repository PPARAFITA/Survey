import { Link } from 'react-router-dom';
import Button from '@mui/material/Button';
import React from 'react';


interface Props {
    color: string;
    description: string;
    path: string;

}


function CustomButton({ color, description, path }: Props): React.ReactElement {

    const buttonStyle = {
        backgroundColor: color === 'blue' ? '#2196F3' : 'white',
        color: color === 'blue' ? 'white' : '#2196F3',
        padding: '15px',
        borderRadius: '5px',
        cursor: 'pointer',
    };
    return (

        <Link to={path} style={{ textDecoration: 'none' }}>
            <Button style={buttonStyle} variant="contained">
                {description}
            </Button>
        </Link>
    );
}

export default CustomButton;

/*  
        <Link to={path}>
            <a  style={{ textDecoration: 'none' }}>
                <Button style={buttonStyle} variant="contained" >
                    {description}
                </Button>
            </a>
        </Link>
style={buttonStyle}
className={color === 'blue' ? style.blue : style.white} 

children?: React.ReactNode;
  {children}
className={color === 'blue' ? styles.blue : styles.red} 

<div className={color === 'blue' ? styles.blue : styles.red}>

const MyButton: React.FC<Props> = ({ color, description, Path }) => {
    return (
        <div className='Button_analyze'>
            <Link to={Path}>
                <Button style={buttonStyle.blue} variant="contained" >
                    {description}
                </Button>
            </Link>
        </div>
    );
};

export default MyButton;

/*
function MyButton( Props ) {
  return (
      
      <div className='Button_analyze'>
      <Stack direction="row" spacing={2}>
          <Link to="/Thanks">
              <Button style={buttonStyle} variant="contained"  href="/Thanks"   >
                {Props.label}
              </Button>
          </Link>
      </Stack>
  </div>
 
  )
}
export default MyButton;*/
