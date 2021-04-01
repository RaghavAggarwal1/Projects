import React from 'react';
import ReactDom from 'react-dom';
// import App from ',/App';
import * as serviceWorker from './serviceWorker';
import '/index.CSS';
var element = React.createElement('h1', { className: 'greeting' }, 'Hello, world!');
ReactDom.render(element,document.getElementById('root'));
serviceWorker.unregister();
