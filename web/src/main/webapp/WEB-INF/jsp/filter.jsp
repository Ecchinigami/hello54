<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
    </head>
    <body>
        <form method="post" action="filter">
            <fieldset>
                <legend>Filter</legend>

                <label for="maxTemperature">Temperature maximale <span >*</span></label>
                <input type="text" id="maxTemperature" name="maxTemperature" value=""  />
                <br />

                <label for="minTemperature">Temperature minimale<span >*</span></label>
                <input type="text" id="minTemperature" name="minTemperature"  />
                <br />

                <label for="intervalDeTemps">interval de temps <span>*</span></label>
                <input type="intervalDeTemps" id="intervalDeTemps" name="intervalDeTemps"  />
                <br />
                <input type="submit" value="Done" />
                <br />
            </fieldset>
        </form>
    </body>
</html>