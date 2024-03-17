import React, { type FormEvent } from 'react';
import { Form } from 'react-router-dom';
import '../../App.css';
import SelectList from '../../common/components/molecules/list.component';
import RadioButtonUnchecked from '@mui/icons-material/RadioButtonUnchecked';
import { CustomButton, RadioButtonsGroup } from '../../common';
import mockData from '../../data';

const LITERALS ={header: 'Welcome to the Digital Hub Survey' }

export const FormMood = () => {
 

    function handleSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();
        new FormData(event.currentTarget);

    }

    return (
        <div className="App">
            <main className="main" style={{ minHeight: 'calc(100vh - 13vh)' }} >

                <form onSubmit={handleSubmit}>
                    <h2 className='texto_header'> {LITERALS.header}</h2>
                    <p className='negrita'>Feel free, the form is completely anonymous. Sorry, but all questions are mandatory  🤓.
                        Select your team and Hey Ho, Let’s Go 🤟</p>

                    <SelectList></SelectList>
                    <div className='sombreado'>
                        <p >Feelings traffic lights      </p>
                        <br />
                        <RadioButtonUnchecked name='answer' className='RedButton' id='uncheckedbutton' />    <p className='uncheckedbutton'> Doesn’t mean Perfect. It just means the squad is happy with this, and see no major need for improvement right now. </p> <br />
                        <RadioButtonUnchecked name='answer' className='GreenButton' id='uncheckedbutton' />   <p> Means there are some important problems that need addressing, but it’s not a disaster. </p><br />
                        <RadioButtonUnchecked name='answer' className='OrangeButton' id='uncheckedbutton' />  <p> Means this really sucks and needs to be improved.  </p> <br />
                    </div>
                    <br />
                    <div className="línea-horizontal"></div>
                    <br />

                    {mockData.map((dataItem) => (
                        <div key={dataItem.id}>
 
                            <RadioButtonsGroup  question = {dataItem.question} answer1={dataItem.answer1} answer2={dataItem.answer2} answer3={dataItem.answer3} />
                            <div className="línea-horizontal"></div>
                        </div>
                    ))}






                    <p className='Title'>Extra ball! Would you like to add something else?</p>
                    <div className='Button'>
                        <CustomButton color={'blue'} description={"Submit"} path={"/Thanks"} />
                    </div>

                </form>
            </main >

        </div>

    )
}
;

