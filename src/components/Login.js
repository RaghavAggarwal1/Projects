import React, { Component } from 'react';
// import { render } from 'react-dom';
class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: "", password: ""
        };
    }
    handleChange = (e) => {
        this.setState({
            [e.target.name] : e.target.value
         });
    }
    handleSubmit = (e) => {
        let reqObj = {}
        reqObj.email = this.state.email
        reqObj.password = this.state.password
        console.log("reqObj-->", reqObj)
      }

    render() {
        return (
            <div>
                <h1>Login</h1>
                <p>Please Login</p>
                <label for="email">email:</label>
                <input type="text" id="email" name="email" r equired onChange={this.handleChange}></input> <br /> <pre />
                <label for="password">password:</label>
                <input type="password" id="password" name="password" required onChange={this.handleChange}></input> <br />  <pre />
                <button type="button"onClick={this.handleSubmit}>Login</button>
            </div>

        );
    }
}

export default Login;
