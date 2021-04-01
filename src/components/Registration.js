import React, { Component } from 'react';
import axios from 'axios';

class Registration extends Component {
   constructor(props) {
      super(props);
      this.state = {
         name: "", age: "", email: "", password: ""
      };
   }

   handleChange = (e) => {
      this.setState({
         [e.target.name] : e.target.value
      });
   }
   handleSubmit = (e) => {
     let reqObj = {}
     reqObj.name = this.state.name
     reqObj.age = this.state.age
     reqObj.email = this.state.email
     reqObj.password = this.state.password
     console.log("reqObj-->", reqObj)

     axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
     axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
     axios.post(`http://localhost:8083/Ecommerce/register?email=${reqObj.email}&pass=${reqObj.password}&name=${reqObj.name}&age=${reqObj.age}`).then(function(response){
         console.log("response-->",response)
     }).catch(function(err){
         console.log("err-->",err)
     });

   }


   render() {
      return (
         <div>
            <h1>Registration</h1>
            <p>Enter Details for signing up</p>
            <label for="name">First name:</label>
            <input type="text" id="name" name="name" required onChange={this.handleChange} ></input> <br /><pre />
            <label for="age">age:</label>
            <input type="text" id="age" name="age" required onChange={this.handleChange}></input> <br /> <pre />
            <label for="email">email:</label>
            <input type="text" id="email" name="email" required onChange={this.handleChange}></input> <br /> <pre />
            <label for="password">password:</label>
            <input type="password" id="password" name="password" required onChange={this.handleChange}></input> <br />  <pre />
            <button type="button" onClick={this.handleSubmit}>Register</button>

         </div>

      );
   }
}

export default Registration;
