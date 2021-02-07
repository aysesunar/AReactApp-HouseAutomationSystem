import React from 'react';
import ScriptTag from 'react-script-tag';
import { render } from 'react-dom';
import Thermometer from 'react-thermometer-chart';
import axios from 'axios';
import {
  CButton,
  CCard,
  CCardBody,
  CCardFooter,
  CCardHeader,
  CCol,
  CForm,
  CFormGroup,
  CInput,
  CRow,
} from '@coreui/react'



function submitChange(degree){
  console.log(degree);
  axios({
    method: 'post',
    url: '/api/setTemperature' + '/' + degree,
  });
  window.location.reload(true);
}



class temperature extends React.Component {
  constructor(props) {
    super(props);
 
    this.state = {
      data:[]
    };
  }

   componentDidMount(){
    axios.get('/api/getTemperature')
    .then((response) => {
      this.setState({data: response.data});
    }).catch(function (error) {
      console.log(error);
    });
   }

   handleChange(e){
    console.log(e.target.value);
    this.state.data = e.target.value;
  }
   

   render() {
     console.log(this.state.data);
     return (
    <>
    <CRow>
    <Thermometer width="100px" height="240px" steps={5} minValue={10} maxValue={50} currentValue={this.state.data}> </Thermometer>
        <CCol xs="2" md="2">
          <CCard>
            <CCardHeader>
              Input temperature 
            </CCardHeader>
            <CCardBody>
              <CForm action="" method="post" className="form-horizontal">
                <CFormGroup row>
                  <CCol xs="8">
                    <CInput onChange={(e) => this.handleChange(e)} placeholder="" />
                  </CCol>
                </CFormGroup>
              </CForm>
            </CCardBody>
            <CCardFooter>
              <CButton type="submit" size="sm" color="primary" onClick={(e) => submitChange(this.state.data)}>Submit</CButton>
            </CCardFooter>
          </CCard>
        </CCol>
      </CRow>
    </>
  )
 }
}


export default temperature