import React, { Component  } from "react";
import FindOddIntService from "../services/findoddint.service";

export default class FindOddInt extends Component {
    constructor(props) {
        super(props);
        this.onChangeNum = this.onChangeNum.bind(this);
        this.addNum = this.addNum.bind(this);
        this.clearNum = this.clearNum.bind(this);
        this.find = this.find.bind(this);
        this.state = {
            num : null,
            nums:[],
            data:null,
            error : null,
            warning : null,
        };   
    }

    onChangeNum(e){
        this.setState({
            num: e.target.value
          });
    }

    clearNum(){
        this.setState({
            nums:[],
            num : null,
            data : null
          });
    }

    addNum() {
        const num = this.state.num;
        if(!num){
            this.setState({
                warning: 'Please input some number',
                error : null,
                data : null,
            });
        }else{
            this.setState({
                nums:[...this.state.nums, this.state.num]
              });
        }
        
    }

    find() {
        const data = this.state.nums;
        if(data.length <= 0){
            this.setState({
                warning: 'Please input some message',
                error : null,
                data : null,
            });
        }else{
            FindOddIntService.find(data)
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
                <h4>Find ODD Number</h4>
                <div className="form-group">
                  <label htmlFor="title">Number</label>
                  <input
                    type="number"
                    className="form-control"
                    id="num"
                    required
                    value={this.state.num}
                    onChange={this.onChangeNum}
                    name="num"
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
                        Numbers in list : 
                        <ul>
                        {
                        this.state.nums.map((item, index) => 
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
                       Should be return {this.state.data.num},
                       because it occurs {this.state.data.occ} time.
                    </div>
                    
                }
                <button onClick={this.addNum} className="btn btn-info m-1">
                  Add
                </button>
                <button onClick={this.clearNum} className="btn btn-danger m-1">
                  Clear
                </button>
                
                {
                    this.state.nums.length > 0 &&
                    <button onClick={this.find} className="btn btn-success m-1">
                        Submit
                    </button>
                }
                
              </div>
            
          </div>
        );
      }
    
}