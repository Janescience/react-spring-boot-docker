import React, { Component } from "react";
import PermutationService from "../services/permutation.service";

export default class Permutation extends Component {
    constructor(props) {
        super(props);
        this.onChangeText = this.onChangeText.bind(this);
        this.getShuffings = this.getShuffings.bind(this);
        this.state = {
            text: "",
            data:[],
            error : null,
            warning : null,
            submitted: false
        };

        
    }

    onChangeText(e) {
        this.setState({
            text: e.target.value
        });
    }

    getShuffings() {
        const data = this.state.text;
        if(!data){
            this.setState({
                warning: 'Please input some message',
                error : null,
                data : [],
                submitted: false
            });
        }else{
            PermutationService.shuffings(data)
            .then(response => {
                this.setState({
                    data: response.data.data,
                    error:null,
                    warning : null,
                    submitted: true
                });
                console.log('shuffings : ',response.data);
            })
            .catch(e => {
                this.setState({
                    error: e.message,
                    data : [],
                    warning : null,
                    submitted: false
                });
                console.log(e);
            });
        }
        
    }


      render() {
        return (
          <div className="submit-form">
            
              <div>
                <h4>Permutation</h4>
                <div className="form-group">
                  <label htmlFor="title">Message</label>
                  <input
                    type="text"
                    className="form-control"
                    id="text"
                    required
                    value={this.state.text}
                    onChange={this.onChangeText}
                    name="text"
                  />
                </div>
                {
                    this.state.warning != null &&
                    <div>
                        Warning : {this.state.warning}
                    </div>
                }
                {
                    this.state.error ? (
                    <div>
                        Error : {this.state.error}
                    </div>
                ) : (
                    <ul>
                        {
                        this.state.data.map((item, index) => 
                            (
                                <li key={index}>{item}</li>
                            ))
                        }
                    </ul>
                )}
                <button onClick={this.getShuffings} className="btn btn-success">
                  Submit
                </button>
              </div>
            
          </div>
        );
      }
    
}