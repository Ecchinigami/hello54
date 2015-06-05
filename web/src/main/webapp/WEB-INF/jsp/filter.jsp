<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Inscription</title>
</head>
<body>
    <f:form method="post" action="filter" >
        <fieldset>
            <legend>Filter</legend>

            <label for="maxTemperature">Temperature maximale</label>
            <input type="text" id="maxTemperature" name="maxTemperature" value="${maxTemperature }"/> <br />

            <label for="minTemperature">Temperature minimale</label>
            <input type="text" id="minTemperature" name="minTemperature" value="${minTemperature }" /> <br />

            <label for="intervalDeTemps">Interval de temps</label>
            <input type="intervalDeTemps" id="intervalDeTemps"
                name="intervalDeTemps" value="${intervalDeTemps }"/> <br /> <input type="submit" value="Done" />
                
            <br />
        </fieldset>
    </f:form>
</body>
</html>