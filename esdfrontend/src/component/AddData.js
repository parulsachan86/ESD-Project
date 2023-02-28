import {useEffect, useState} from 'react'
import axios from 'axios'
import Multiselect from 'multiselect-react-dropdown';
import swal from 'sweetalert'


const Add = () => {
// for multiselect
var response;
const [selectedDomain, setSelectedDomain] = useState([])
const [selectedSpecialization, setSelectedSpecialization] = useState([])
    const [dep, setDep] = useState([]);
    const [orgid, setOrgID] = useState('');
    const [profile, setProfile] = useState('');
    const [grade, setGrade] = useState(0.00);
    const [intake, setIntake] = useState('');
    const specialization = [
        {
            name:"Theory System and Design"
        },
        {
            name:"Data Science"
        },
        {
            name:"None"
        }
    ]

    const domain = [
        {
            name:"IMtech ECE"
        },
        {
            name:"Mtech CSE"
        },
        {
            name:"None"
        }
    ]

    const onSelect1 =(selectedList, selectedItem) =>{
        setSelectedSpecialization( current => [...current, selectedItem]);
        // console.log(selectedSpecialization)
        }
        
        const onRemove1 =(selectedList, removedItem) =>{
          setSelectedSpecialization((selectd) =>
          selectd.filter((data) => data.name !== removedItem.name));
        //   console.log(selectedSpecialization)
        }

    const onSelect =(selectedList, selectedItem) =>{
        setSelectedDomain( current => [...current, selectedItem]);
        // console.log(selectedDomain)
        }
        
        const onRemove =(selectedList, removedItem) =>{
            // console.log("removed item is", removedItem)
            setSelectedDomain((selectd) =>
            selectd.filter((data) => data.name !== removedItem.name));
            // console.log(selectedDomain)
        }

        

    const getdep = async() => {
        await axios.get('http://localhost:8080/api/organisation/get')
        .then((response)=>{
            setDep(response.data)
        })
    }
    
   
    const handleAdd = async() => {
            for(var i=0; i<selectedDomain.length; i++){
                for(var j=0; j<selectedSpecialization.length; j++){
                    await axios.post('http://localhost:8080/api/placement/add',{
                        profile:profile,
                        specialization:selectedSpecialization[j].name,
                        domain:selectedDomain[i].name,
                        intake:intake,
                        min_grade:grade,
                        organisation:{
                            organisation_id:orgid
                        }
                    })
                    .then((res)=>{
                        // console.log(res.data);
                        response = res.data;
                    })
                    .catch((error)=>{
                        console.log(error);
                    })
                }
            }

            if(response==="Success")
            {
                swal("Success", "Successfully added the data!","success");
                window.location.reload(true);
            }
        
    }
//}

//called on first page load
    useEffect(()=>{
        getdep();
    },[]);

 
    return (
    <div className='container-fluid mt-5'>
        <div className='row'>
            <div className='col'>
                <select className="form-select" aria-label="multiple select example"
                onChange={(event)=>{
                    setOrgID(event.target.value)
                }}
                >
                    {/* <option selected value={''}>Organisation...</option> */}
                    {
                        dep.map((op, index)=>{
                            return(
                                <option key={op.organisation_id} value={op.organisation_id}>{op.name}</option>
                            )
                        })
                    }
                </select>
            </div>
        <div className='col'>
            <Multiselect
            options={specialization} // Options to display in the dropdown
            selectedValues={[]} // Preselected value to persist in dropdown
            onSelect={onSelect1} // Function will trigger on select event
            onRemove={onRemove1} // Function will trigger on remove event
            displayValue="name" // Property name to display in the dropdown options
            placeholder='Specialization'
            />
        </div>
        <div className='col'>
             <Multiselect
            options={domain} // Options to display in the dropdown
            selectedValues={[]} // Preselected value to persist in dropdown
            onSelect={onSelect} // Function will trigger on select event
            onRemove={onRemove} // Function will trigger on remove event
            displayValue="name" // Property name to display in the dropdown options
            placeholder='Domain'
            />
        </div>
        <div className='row mt-5'>
                <div className='col-2'>
                    <div className="form-outline mb-4">
                        <input type="number" id="grades" className="form-control" 
                        onChange={(event)=>{
                            setGrade(event.target.value)
                        }}
                        />
                        <label className="form-label" htmlFor="grade">Min Grade</label>
                    </div>
                </div>
                <div className='col-5'>
                    <div className="form-outline mb-4">
                        <input type="text" id="profile" className="form-control" 
                        onChange={(event)=>{
                            setProfile(event.target.value)
                        }}
                        />
                        <label className="form-label" htmlFor="profile">Profile</label>
                    </div>
                </div>
                <div className='col-5'>
                    <div className="form-outline mb-4">
                        <input type="text" id="intake" className="form-control" 
                        onChange={(event)=>{
                            setIntake(event.target.value)
                        }}
                        />
                        <label className="form-label" htmlFor="intake">Intake</label>
                    </div>
                </div>
        </div> 
            <div className='col-4'>
                <button className='btn btn-primary'
                    onClick={handleAdd}
                >
                    Add
                </button>
            </div>
        </div>
    </div>
    )
}

export default Add