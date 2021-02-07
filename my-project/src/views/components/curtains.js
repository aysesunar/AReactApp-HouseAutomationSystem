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


function handleChange(curtain, e){
  axios({
    method: 'post',
    url: '/api/updateCurtain' + '/' + curtain.id,
  });
  window.location.reload(true);

}

class Curtains extends React.Component {
  constructor(props) {
    super(props);
 
    this.state = {
      data:[]
    };
  }

   componentDidMount(){
    axios.get('/api/getRoomsWithCurtains')
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
                
              {room.curtains.map((curtain, index) => {
                if(curtain.state)
                return<CListGroupItem className="justify-content-between" accent="dark" >
                      <CIcon className={'float-left'} name="cil-line-weight" size={'lg'}/>&nbsp; &nbsp;
                        {curtain.name}
                        <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={curtain.state} onChange={(e) => handleChange(curtain, e)} />
                      </CListGroupItem>
                return<CListGroupItem className="justify-content-between" accent="secondary" >
                        <CIcon className={'float-left'} name="cil-line-weight" size={'lg'}/>&nbsp; &nbsp;
                          {curtain.name}
                          <CSwitch className={'float-right mx-1'} shape={'pill'} color={'primary'} labelOn={'\u2713'} labelOff={'\u2715'}  defaultChecked={curtain.state} onChange={(e) => handleChange(curtain, e)} />
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

export default Curtains
