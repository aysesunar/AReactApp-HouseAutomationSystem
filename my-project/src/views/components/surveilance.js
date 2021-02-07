import React from 'react'

import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CEmbed,
  CEmbedItem
} from '@coreui/react'

const Surveilance = () => {

  return (
    <CRow>
        <CCol>
          <CCard>
            <CCardHeader>
              <h4>Front Door Camera</h4>
            </CCardHeader>
            <CCardBody>
              <CEmbed>
                <CEmbedItem src="https://www.youtube.com/embed/wLoRiTk-awo"/>
              </CEmbed>
            </CCardBody>
          </CCard>
        </CCol>
        <CCol>
          <CCard>
            <CCardHeader>
              <h4>Backdoor Camera</h4>
            </CCardHeader>
            <CCardBody>
              <CEmbed>
                <CEmbedItem src="https://www.youtube.com/embed/CkVJyAKwByw"/>
              </CEmbed>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
  )
}

export default Surveilance