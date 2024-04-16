import { Link } from 'react-router-dom';
import Button from '@mui/material/Button';
import React, { useEffect, useRef } from 'react';
import cx from 'classnames';
import './button.styles.css';  

interface Props {
    color: string;
    description: string;
    path: string;
    actionButton?: (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void;
    isDisabled?: boolean
}

const styleAzul = 'blueButtonStyle';
const styleBlanco = 'whiteButtonStyle';
const buttonStyle = 'baseButtonStyle';
 
export const CustomButton: React.FC<Props> = ({ color, description, path, actionButton, isDisabled }) => {
 
    const buttonClassName = cx(buttonStyle, {
        [styleAzul]: color === 'blue',
        [styleBlanco]: color === 'white',
      });

    
      const buttonRef = useRef<HTMLButtonElement | null>(null);

      useEffect(() => {
        const handleScrollToTop = () => {
          window.scrollTo({ top: 0, behavior: 'instant' }); 
        };
     
        const button = buttonRef.current;

        if (button && !isDisabled) {
          button.addEventListener('click', handleScrollToTop);
        }
    
        return () => {
          if (button && !isDisabled) {
            button.removeEventListener('click', handleScrollToTop);
          }
        };
      }, [isDisabled]);
  
 
    return (
       
        <Link to={isDisabled ? '#' : path} style={{ textDecoration: 'none' }}> 
            <Button ref={buttonRef} id='custombutton' onClick= {isDisabled ? e => e.preventDefault() : actionButton} className={buttonClassName}  variant="contained"  disabled={isDisabled}>
                {description}
            </Button>
        </Link>
    );
}
 
