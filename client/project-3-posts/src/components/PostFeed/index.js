import axios from 'axios';
import React, { useState, useEffect } from 'react'
import Post from './Post';

const PostFeed = () => {

    const [posts, setPosts] = useState([]);
    const [searchText, setSearchText] = useState(""); //search string for flitering the posts
    const [filterDate, setFilterDate] = useState(Date.now()); //The actual date being compared to all the posts' creation dates
    const [filterMethod, setFilterMethod] = useState("ALL"); //ALL = No filter, BEFORE = Get all posts made before the date, AFTER = Get all posts made affter the date

    useEffect(() => {

        axios.get("http://localhost:11001/postfeed")
            .then((response) => {
                setPosts(response.data); //Set the posts array to the filtered content
            })
            .catch((error) => {
                console.error(error); //Print error to console
            })
    }, [])


    const sortByTimeOldFirst = () => {

        let sortedPosts = [...posts]; //Make a shallow copy
        sortedPosts.sort((post1, post2) => {
            if (post1.creationDate < post2.creationDate) {
                return -1; //post1 should be second
            }
            else if (post1.creationDate > post2.creationDate) {
                return 1; //post1 should be first
            }
            else {
                return 0; //Are the same
            }
        });
        setPosts(sortedPosts);
    }

    const sortByTimeNewFirst = () => { //METHOD FOR SORTING POSTS BY CREATION DATE, NEWEST FIRST

        let sortedPosts = [...posts]; //Make a shallow copy
        sortedPosts.sort((post1, post2) => {
            if (post1.creationDate < post2.creationDate) {
                return 1; //post1 should be first
            }
            else if (post1.creationDate > post2.creationDate) {
                return -1; //post1 should be second
            }
            else {
                return 0; //Are the same
            }
        });
        setPosts(sortedPosts);
    }

    const sortByMostUpmints = () => { //METHOD FOR SORTING POSTS BY UPMINTS
        let sortedPosts = [...posts]; //Make a shallow copy
        sortedPosts.sort((post1, post2) => {
            if (post1.upmints > post2.upmints) {
                return -1; //post1 should be second
            }
            else if (post1.upmints < post2.upmints) {
                return 1; //post1 should be first
            }
            else {
                return 0; //Are the same
            }
        });
        setPosts(sortedPosts);
    }

    const sortByMostDownmints = () => { //METHOD FOR SORTING POSTS BY  DOWNMINTS
        let sortedPosts = [...posts]; //Make a shallow copy
        sortedPosts.sort((post1, post2) => {
            if (post1.downmints > post2.downmints) {
                return -1; //post1 should be second
            }
            else if (post1.downmints < post2.downmints) {
                return 1; //post1 should be first
            }
            else {
                return 0; //Are the same
            }
        });
        setPosts(sortedPosts);
    }

    const filterByTimeAgo = (numDays) => { //METHOD FOR GETTING ALL THE POSTS MADE ONE DAY AGO OR LATER
        //Set up the date using today
        let pastDate = new Date(Date.now() - (numDays * 24 * 60 * 60 * 1000)); //Go from ms to days
        //Check days prior
        console.log(pastDate.toISOString());
        axios.get(`http://localhost:11001/postfeed/datesearch/after/${pastDate.toISOString()}`) //Get all the post occurring after this date.
        .then((resp) => {
            setPosts(resp.data);
        })
        .catch((error) => {
            console.error(error);
        });
    }

   
    const searchChangeHandler = (event) => { //For posts search bar
        const {  value } = event.target;
        setSearchText(value);
    }

    const searchSubmitHandler = (event) => { //Change the posts array on submit
        event.preventDefault(); //No page refresh
        axios.get(`http://localhost:11001/postfeed/textsearch/${searchText}`)
            .then((response) => {
                setPosts(response.data); //Set the state to this new array (unsorted)
            })
            .catch((error) => {
                console.error(error)
            });
    }

    const dateChangeHandler = (event) => {
        const { name, value } = event.target;
        console.log(value);
        if (name === "filter_method") {
            setFilterMethod(value);
        }
        else if (name === "filter_date") {
            console.log(value);
            setFilterDate(value);
        }
    }

    const dateSubmitHandler = (event) => { //Change the posts array on submit
        event.preventDefault();
        let benchmarkDate = new Date(filterDate);

        switch (filterMethod) {
            case "BEFORE":
                axios.get(`http://localhost:11001/postfeed/datesearch/before/${benchmarkDate.toISOString()}`)
                    .then((resp) => {
                        setPosts(resp.data);
                    })
                    .catch((error) => {
                        console.error(error);
                    });
                break;
            case "AFTER":
                axios.get(`http://localhost:11001/postfeed/datesearch/after/${benchmarkDate.toISOString()}`)
                    .then((resp) => {
                        setPosts(resp.data);
                    })
                    .catch((error) => {
                        console.error(error);
                    });
                break;
            case "ALL":
                axios.get(`http://localhost:11001/postfeed`)
                    .then((resp) => {
                        setPosts(resp.data);
                    })
                    .catch((error) => {
                        console.error(error);
                    });
                break;
            default:

                break;
        }




    }

    ////////////////////// MAKING FAKE POSTS AND USERS FOR TESTING
    let owner1 = {
        id: 1,
        name: "Peter Lankton",
        email: "p.lankton@gmail.com"
    }
    let post1 = {
        id: 101,
        title: "Chum Bucket Advertisement",
        description: "This restaurant is simply the best.",
        owner: owner1
    }

    let owner2 = {
        id: 2,
        name: "Eugene Krabs",
        email: "krabs@gmail.com"
    }
    let post2 = {
        id: 102,
        title: "Krusty Krab 2 Advertisement",
        description: "Hello! I like money!",
        owner: owner2
    }

    let owner3 = {
        id: 3,
        name: "Spongebob Squarepants",
        email: "square@gmail.com"
    }
    let post3 = {
        id: 103,
        title: "Krusty Krab Appreciation Post",
        description: "The Krusty Krab is the bestest place to work!",
        owner: owner3
    }

    let postArray = [post1, post2, post3];
    /////////////////////////////////////

    /////Calculation for the default value (the current date/time) for the time input field
    const todayRaw = new Date(Date.now());
    const myTimeZoneOffset = todayRaw.getTimezoneOffset();
    const today = new Date(todayRaw.getTime() - (myTimeZoneOffset * 60 * 1000));
    ///////////////////////////
    return (
        <>
            <form className="text-center mb-4" onSubmit={searchSubmitHandler}>
                <input className="w-50" type="text" onChange={searchChangeHandler} placeholder="Search for a post..." name="searchbar" />
                <button type="submit">Go!</button>

            </form>
            <form className="text-center mb-4" onSubmit={dateSubmitHandler}>
                <label className='form-label'>Filter your previous orders</label> <br />
                <div className="btn-group " role="group"  onChange={dateChangeHandler}>
                    <input type="radio" style={{ display: "none" }} className="btn-check" name="filter_method" id="btnradio1" value="BEFORE" autoComplete="off" />
                    {
                        filterMethod === "BEFORE" ?
                            <label className="btn btn-danger" htmlFor="btnradio1">Before</label>
                            :
                            <label className="btn btn-info" htmlFor="btnradio1">Before</label>
                    }


                    <input type="radio" style={{ display: "none" }} className="btn-check" name="filter_method" id="btnradio2" value="AFTER" autoComplete="off" />
                    {
                        filterMethod === "AFTER" ?
                            <label className="btn btn-danger" htmlFor="btnradio2">After</label>
                            :
                            <label className="btn btn-info" htmlFor="btnradio2">After</label>
                    }

                    <input type="radio" style={{ display: "none" }} className="btn-check" name="filter_method" id="btnradio3" value="ALL" autoComplete="off" />
                    {
                        filterMethod === "ALL" ?
                            <label className="btn btn-danger" htmlFor="btnradio3">No Filter</label>
                            :
                            <label className="btn btn-info" htmlFor="btnradio3">No Filter</label>
                    }

                </div>
                <input className="w-75 text-center" step="any" type="datetime-local" onChange={dateChangeHandler} defaultValue={today.toISOString().split('.')[0]} name="filter_date" />
                <button type="submit">Go!</button>

            </form>
            <button onClick={sortByTimeOldFirst}>Oldest</button>
            <button onClick={sortByTimeNewFirst}>Newest</button>
            <button onClick={sortByMostUpmints}>Most Upminted</button>
            <button onClick={sortByMostDownmints}>Most Downminted</button>
            <button onClick={() => filterByTimeAgo(1)}>Yesterday</button>   
            <button onClick={() => filterByTimeAgo(7)}>Last Week</button>
            <button onClick={() => filterByTimeAgo(20)}>Last Month</button>
            <button onClick={() => filterByTimeAgo(365)}>Last Year</button>
            <div className="container d-flex justify-content-center">

                {posts.length === 0 ?

                    <h1> It's quiet in here. Make a post!</h1>

                    :
                    <ol>
                        {
                            posts.map(post => {
                                return <li key={post.id}><Post data={post} /></li>
                            })
                        }
                    </ol>

                }
            </div>

        </>
    );

}

export default PostFeed;