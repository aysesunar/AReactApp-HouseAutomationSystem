import React, { Component }  from 'react'
import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CSwitch,
  CListGroup,
  CListGroupItem,
} from  '@coreui/react'
import CIcon from '@coreui/icons-react';
import axios from 'axios';


function handleChange(light, e){
  axios({
    method: 'post',
    url: '/api/updateLight' + '/' + light.id,
  });
  window.location.reload(true);

}

class Lights extends React.Component {
  constructor(props) {
    super(props);
 
    this.state = {
      data:[]
    };
  }

   componentDidMount(){
    axios.get('/api/getRoomsWithLights')
    .then((response) => {
      this.setState({data: response.data});
    }).catch(function (error) {
      console.log(error);
    });
   }

   calculateAllChildLightStates(lights) {
    for (const [index, value] of lights.entries()) {
      if(!value.state){
        return false;
      }
    }
    return true;
  }

 
  render() {
    return <CRow>
    {this.state.data.map((room, index) => (
        <CCol sm="12" xl="6">
          <CCard>
            <CCardHeader color = {'gradient-secondary'} >
              <big>{room.room.name}</big>
              <CSwitch size={'lg'} className={'float-right mx-1'} shape={'pill'} color={'primary'}  defaultChecked={this.calculateAllChildLightStates(room.lights)}/>

            </CCardHeader>
            <CCardBody>
              <CListGroup accent>
                
              {room.lights.map((light, index) => {
                if(light.state)
                return<CListGroupItem className="justify-content-between" accent="warning" >
                        <CIcon className={'float-left'} name="cil-lightbulb"  size={'lg'}/>&nbsp; &nbsp;
                        {light.name}
                        <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={light.state} onChange={(e) => handleChange(light, e)} />
                      </CListGroupItem>
                return<CListGroupItem className="justify-content-between" accent="secondary" >
                        <CIcon className={'float-left'} name="cil-lightbulb"  size={'lg'}/>&nbsp; &nbsp;
                        {light.name}
                        <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={light.state} onChange={(e) => handleChange(light, e)} />
                      </CListGroupItem>
              })}
                
              </CListGroup>
            </CCardBody>
          </CCard>

        </CCol>
      ))}
    </CRow>;
  }
}

export default Lights
