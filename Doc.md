React app Design Decisions:

- The react app is located in the "my-project" folder.
- I used react js as the javascript template.
- I used the coreui react template from this link: https://coreui.io/react/#compare and have extended the template to adjust it to my project
- The frontend could be run by navigating to the project direectory and typing in "npm run" in the terminal.
- In the main layout there is a Sidebar, Header, Footer and Content component. 
- All content components, in other words, all components that are presented in the screen are in the views folder. 
- In order to communicate with the server side (SpringBootServer), I configured the proxy (located in package.json) as "http://localhost:8081" which is the localhost adress my spring boot aplication is configured to run at.

Sprig Boot aplication (Server side)

- In order for the frontend to be able have http connection, I built a backend using springboot. 
- I used the MVC model for the backend side.
- Ther server side is configured to get and write into the local database I created with wamp server.

