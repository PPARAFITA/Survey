import { Link } from 'react-router-dom';
import Button from '@mui/material/Button';
import React from 'react';
import cx from 'classnames';
import './button.styles.css';

interface Props {
    color: string;
    description: string;
    path: string;
}

const styleAzul = 'blueButtonStyle';
const styleBlanco = 'whiteButtonStyle';
const color = 'blue'; 
const buttonStyle = 'baseButtonStyle';


export const CustomButton: React.FC<Props> = ({ color, description, path }) => {

    console.log('Valor de color:', color);

    const buttonClassName = cx(buttonStyle, {
        [styleAzul]: color === 'blue',
        [styleBlanco]: color === 'white',
      });

    return (

        <Link to={path} style={{ textDecoration: 'none' }}>
            <Button className={buttonClassName}   variant="contained">
 
                {description}
            </Button>
        </Link>
    );
}
 
/*  
      const buttonStyle = {
        padding: '15px',
        borderRadius: '5px',
        cursor: 'pointer',
        backgroundColor: color === 'blue' ? '#2196F3' : 'white',
        color: color === 'blue' ? 'white' : '#2196F3',
    };
className={buttonClassName}

    const buttonClassName = cx(buttonStyle, {
        [styleAzul]: color === 'blue',
        [styleBlanco]: color === 'white',
      });

    const buttonStyle = {
        backgroundColor: color === 'blue' ? '#2196F3' : 'white',
        color: color === 'blue' ? 'white' : '#2196F3',
        padding: '15px',
        borderRadius: '5px',
        cursor: 'pointer',
    };
style={buttonStyle}
import cx from 'classnames';
className={cx(buttonStyle, color === 'blue' ? styleAzul : styleBlanco)}
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
