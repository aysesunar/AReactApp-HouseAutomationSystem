import {
  CBadge,
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CListGroup,
  CListGroupItem,
  CRow,
  CWidgetIcon,
} from '@coreui/react'
import React, { lazy,useState } from 'react';
import CIcon from '@coreui/icons-react';
import axios from 'axios';




class Rooms extends React.Component {
  constructor(props) {
    super(props);
 
    this.state = {
      data:[],
      temperature:undefined
    };
  }

   componentDidMount(){
    axios.get('/api/findRoomsWithAllComponents')
    .then((response) => {
      this.setState({data: response.data});
    }).catch(function (error) {
      console.log(error);
    });

    axios.get('/api/getTemperature')
    .then((response) => {
      this.setState({temperature: response.data});
    }).catch(function (error) {
      console.log(error);
    });
   }

 
  render() {
    let degree = this.state.temperature + " ° C";
    return (
      <>
      
        <CRow>
          <CCol xs="12" sm="6" lg="3" >
              <CWidgetIcon text="" header={degree} color="danger" iconPadding={false}>
                <CIcon width={48} name="cil-speedometer"/>
              </CWidgetIcon>
                
            </CCol>
        </CRow>
          <CRow>
          {this.state.data.map((room, index) => (
          <CCol sm="12" xl="6">
            <CCard>
              <CCardHeader >
                <big>{room.room.name}</big>
              </CCardHeader>
              <CCardBody>
                <CListGroup accent>
                  <CListGroupItem className="justify-content-between" accent="warning" color="warning">
                    Number Of Lights
                    <CBadge className="float-right" shape="pill" color="warning">{room.lights.length}</CBadge>
                  </CListGroupItem>
                  <CListGroupItem className="justify-content-between" accent="dark" color="dark">
                    Number Of Curtains
                    <CBadge className="float-right" shape="pill" color="dark">{room.curtains.length}</CBadge>
                  </CListGroupItem>
                  <CListGroupItem className="justify-content-between" accent="info" color="info">
                    Number Of Air Conditioners
                    <CBadge className="float-right" shape="pill" color="info">{room.airconditioners.length}</CBadge>
                  </CListGroupItem>
                  <CListGroupItem className="justify-content-between" accent="primary" color="primary">
                    Number Of Televisions
                    <CBadge className="float-right" shape="pill" color="primary">{room.televisions.length}</CBadge>
                  </CListGroupItem>
                </CListGroup>
              </CCardBody>
            </CCard>

          </CCol>
          ))}
        </CRow>
      </>
    )
  }
}

export default Rooms
