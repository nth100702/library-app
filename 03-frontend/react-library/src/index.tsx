import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import {App} from './App';
import { BrowserRouter } from 'react-router-dom';
import { loadStripe } from '@stripe/stripe-js';
import { Elements } from '@stripe/react-stripe-js'

const stripePromise = loadStripe('pk_test_51Q9UJj08zh50kAarEQimEv64XQei6leVD6n0e2M5cQaIeiJL0FyAGsKpF6YKowiubyHz7fC8qOqo8HzR32hOFIwZ00YwZEDSyQ')

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);

