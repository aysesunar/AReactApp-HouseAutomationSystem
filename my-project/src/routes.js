import React from 'react';

const Rooms = React.lazy(() => import('./views/rooms/Rooms'));
const Lights = React.lazy(() => import('./views/components/lights'));
const Curtains = React.lazy(() => import('./views/components/curtains'));
const Temperature = React.lazy(() => import('./views/components/temperature'));
const AC = React.lazy(() => import('./views/components/airconditioning'));
const Surveilance = React.lazy(() => import('./views/components/surveilance'));
const television = React.lazy(() => import('./views/components/television'));

const routes = [
  { path: '/', exact: true, name: 'Home' },
  { path: '/rooms', name: 'Rooms', component: Rooms },
  { path: '/lights', name: 'Lights', component: Lights },
  { path: '/curtains', name: 'Curtains', component: Curtains },
  { path: '/temperature', name: 'Temperature', component: Temperature },
  { path: '/airconditioning', name: 'Air Conditioning', component: AC },
  { path: '/surveilance', name: 'Surveilance', component: Surveilance },
  { path: '/television', name: 'Television', component: television },
];

export default routes;
