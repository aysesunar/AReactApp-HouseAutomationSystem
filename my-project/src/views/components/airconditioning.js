import React from 'react'
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


function handleChange(airconditioner, e){
  axios({
    method: 'post',
    url: '/api/updateAc' + '/' + airconditioner.id,
  });
  window.location.reload(true);

}

class airconditioning extends React.Component {
  constructor(props) {
    super(props);
 
    this.state = {
      data:[]
    };
  }

   componentDidMount(){
    axios.get('/api/getRoomsWithAcs')
    .then((response) => {
      this.setState({data: response.data});
    }).catch(function (error) {
      console.log(error);
    });
   }

 
  render() {
    return <CRow>
    {this.state.data.map((room, index) => (
        <CCol sm="12" xl="6">
          <CCard>
            <CCardHeader color = {'gradient-secondary'} >
              <big>{room.room.name}</big>
            </CCardHeader>
            <CCardBody>
              <CListGroup accent>
                
              {room.airconditioners.map((airconditioner, index) => {
                if(airconditioner.state)
                return <CListGroupItem className="justify-content-between" accent="info" >
                        <CIcon className={'float-left'} name="cil-snowflake" size={'lg'} />&nbsp; &nbsp;
                        {airconditioner.name}
                        <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={airconditioner.state} onChange={(e) => handleChange(airconditioner, e)} />
                      </CListGroupItem>
                
                return <CListGroupItem className="justify-content-between" accent="secondary" >
                        <CIcon className={'float-left'} name="cil-snowflake" size={'lg'} />&nbsp; &nbsp;
                        {airconditioner.name}
                        <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={airconditioner.state} onChange={(e) => handleChange(airconditioner, e)} />
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

export default airconditioning
