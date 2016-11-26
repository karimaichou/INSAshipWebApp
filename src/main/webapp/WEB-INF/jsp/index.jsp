<%--
  Created by IntelliJ IDEA.
  User: borik
  Date: 11/18/2016
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p>
    Welcome!
</p>

<p>
    Borek: Synchronized project with Karima's JPA entities. I redid the class relationships with ER diagram manager (View
    -> Persistence -> Right Click:emf -> Er diagram) because I  was having some errors (possibly IDE related). In the
    process I have removed some delete cascades, we can add them back later. I also changed some names of attributes
    to be english and so that they follow some naming conventions (i am deeply sorry for that Karima:)! ). I didnt copy over
    the dao object because, as we discussed, we will use repositories instead. I also decided to stay on embedded database
    so we would not have to install any datasource on our computers, since we might be moving to different database
    solution later anyway. The project is now ready for database user security setup and registration page! Let's get to work!
</p>

<p>
    Borek: Implemented basic authentication with Spring Security. TODO authentication with database (missing DB).
</p>

<p>
    username:admin <br>
    password:admin
</p>

<p>
    Borek: Added example page with instructions, check it out. Dont delete please. But you need to log in to see it! :)
</p>

<p>
    And the cat stays!!! (#nojoke)
</p>