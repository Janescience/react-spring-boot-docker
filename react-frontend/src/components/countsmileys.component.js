import React, { Component  } from "react";
import CountSmileysService from "../services/countsmileys.service";

export default class CountSmileys extends Component {
    constructor(props) {
        super(props);
        this.onChangeSmile = this.onChangeSmile.bind(this);
        this.addSmile = this.addSmile.bind(this);
        this.clearSmile = this.clearSmile.bind(this);
        this.count = this.count.bind(this);
        this.state = {
            smile : null,
            smiles:[],
            data:null,
            error : null,
            warning : null,
        };   
    }

    onChangeSmile(e){
        this.setState({
            smile: e.target.value
        });
    }

    clearSmile(){
        this.setState({
            smiles:[],
            smile : null,
            data : null
          });
    }

    addSmile() {
        const smile = this.state.smile;
        if(!smile){
            this.setState({
                warning: 'Please input some smile',
                error : null,
                data : null,
            });
        }else{
            this.setState({
                smiles:[...this.state.smiles, this.state.smile]
            });
        }
    }

    count() {
        const data = this.state.smiles;
        if(data.length <= 0){
            this.setState({
                warning: 'Please input some message',
                error : null,
                data : null,
            });
        }else{
            CountSmileysService.count(data)
            .then(response => {
                this.setState({
                    data: response.data.data,
                    error:null,
                    warning : null,
                });
                console.log('find : ',response.data);
            })
            .catch(e => {
                this.setState({
                    error: e.message,
                    data : null,
                    warning : null,
                });
                console.log(e);
            });
        }
        
    }


      render() {
        return (
          <div className="submit-form">
            
              <div>
                <h4>Count Smileys Faces</h4>
                <div className="form-group">
                  <label htmlFor="title">Smile</label>
                  <input
                    type="text"
                    className="form-control"
                    id="smile"
                    required
                    value={this.state.smile}
                    onChange={this.onChangeSmile}
                    name="smile"
                  />
                </div>
                {
                    this.state.warning != null &&
                    <div>
                        Warning : {this.state.warning}
                    </div>
                }
                {
                    this.state.error != null && 
                    <div>
                        Error : {this.state.error}
                    </div>
                }
                {
                    <div>
                        Smiles in list : 
                        <ul>
                        {
                        this.state.smiles.map((item, index) => 
                            (
                                <li key={index}>{item}</li>
                            ))
                        }
                        </ul>
                    </div>
                }
                {
                    this.state.data != null && 
                    <div>
                       Smiley faces count is {this.state.data}.
                    </div>
                    
                }
                <button onClick={this.addSmile} className="btn btn-info m-1">
                  Add
                </button>
                <button onClick={this.clearSmile} className="btn btn-danger m-1">
                  Clear
                </button>
                
                {
                    this.state.smiles.length > 0 &&
                    <button onClick={this.count} className="btn btn-success m-1">
                        Submit
                    </button>
                }
                
              </div>
            
          </div>
        );
      }
    
}