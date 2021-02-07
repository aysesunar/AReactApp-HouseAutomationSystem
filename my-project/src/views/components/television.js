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


function handleChange(television, e){
  axios({
    method: 'post',
    url: '/api/updateTelevision' + '/' + television.id,
  });
  window.location.reload(true);

}

class television extends React.Component {
  constructor(props) {
    super(props);
 
    this.state = {
      data:[]
    };
  }

   componentDidMount(){
    axios.get('/api/getRoomsWithTelevisions')
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
                
              {room.televisions.map((television, index) => {
                if(television.state)
                return<CListGroupItem className="justify-content-between" accent="primary" >
                      <CIcon className={'float-left'} name="cil-tv" size={'lg'}/>&nbsp; &nbsp;
                        {television.name}
                        <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={television.state} onChange={(e) => handleChange(television, e)} />
                      </CListGroupItem>
                return<CListGroupItem className="justify-content-between" accent="secondary" >
                        <CIcon className={'float-left'} name="cil-tv" size={'lg'}/>&nbsp; &nbsp;
                        {television.name}
                        <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={television.state} onChange={(e) => handleChange(television, e)} />
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

export default television
