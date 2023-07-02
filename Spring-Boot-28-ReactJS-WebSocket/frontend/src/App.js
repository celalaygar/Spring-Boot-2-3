import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import SockJS from 'sockjs-client';
import { over } from 'stompjs';

var stompClient = null;

const App = () => {
  const [users, setUsers] = useState([{}]);
  const [loading, setLoading] = useState(true);
  const [userInfo, setUserInfo] = useState({
    "id": "1",
    "username": "2",
    "password": "3",
  });

  const connect = () => {
    let Sock = new SockJS('http://localhost:8501/user');
    stompClient = over(Sock);
    stompClient.connect({}, onConnected, (e) => console.log(e));
  }

  const onConnected = () => {
    console.log("connected")
    stompClient.subscribe('/topic/add-user', onUserReceived);
  }
  const onUserReceived = (payload) => {
    console.log("payload")
    console.log(JSON.parse(payload.body))
    users.push(JSON.parse(payload.body))
    setUsers([...users])
  }

  const sendUserInformation = () => {
    if (stompClient) {
      stompClient.send("/app/user", {}, JSON.stringify(userInfo));
    } else {

      console.log("failed : " + stompClient)
    }
  }

  const onchange = (e) => {
    let body = { ...userInfo }
    body[e.target.name] = e.target.value;
    setUserInfo(body);
  }


  // useEffect(() => {
  //   console.log("connected.." + loading)
  //   if (loading) {
  //     connect();
  //     console.log("connected..")
  //   }
  // }, [loading]);
  return (
    <div className="App">
      <div>
        <h5>User Save Form</h5>
        <hr />
        <div>
          <table>

            <tr>
              <td><label>ID : </label></td>
              <td><input type="text" name="id" value={userInfo?.id} onChange={e => onchange(e)}></input></td>
            </tr>
            <tr>
              <td><label>Username : </label></td>
              <td><input type="text" name="username" value={userInfo?.username} onChange={e => onchange(e)}></input></td>
            </tr>
            <tr>
              <td><label>Password : </label></td>
              <td><input type="text" name="password" value={userInfo?.password} onChange={e => onchange(e)}></input></td>
            </tr>
            <tr>
              <td></td>
              <td><button onClick={connect}>connect</button></td>
            </tr>
            <tr>
              <td></td>
              <td><button onClick={sendUserInformation}>Save</button></td>
            </tr>
          </table>
        </div>
        <hr />
        <h5>Users</h5>
        <hr />
        <table>
          <thead>
            <th>ID</th>
            <th>SystemNumber</th>
            <th>Username</th>
            <th>Password</th>
            <th></th>
          </thead>
          <tbody>
            {users.length > 0 && users.map((item, key) => {
              return <tr key={key}>
                <td>
                  {item.id}
                </td>
                <td>
                  {item.systemNumber}
                </td>
                <td>
                  {item.username}
                </td>
                <td>
                  {item.password}
                </td>
              </tr>
            })}

          </tbody>
        </table>

      </div>
    </div>
  );
}

export default App;
