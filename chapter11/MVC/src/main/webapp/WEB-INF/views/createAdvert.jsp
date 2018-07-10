<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car Application</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <a href="./logout">
                        <button type="button" class="btn btn-default btn-danger navbar-btn">Log out</button>
                    </a>
                </div>
            </form>
        </div>
    </nav>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm"></div>
        <div class="col-sm">
            <form class="form-class" method="post" action="/">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" class="form-control" autofocus
                           placeholder="Sell Lada Granta" required/>
                </div>
                <div class="form-group">
                    <label for="producer">Producer</label>
                    <select class="form-control" id="producer">
                        <option value="1">Audi</option>
                        <option value="2">BMW</option>
                        <option value="3">Mersedec</option>
                        <option value="4">Lada</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="body">Body</label>
                    <select class="form-control" id="body">
                        <option value="1">Sedan</option>
                        <option value="2">Hatchback</option>
                        <option value="3">Crossover</option>
                        <option value="4">Jeep</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="gearbox">Gearbox</label>
                    <select class="form-control" id="gearbox">
                        <option value="1">Mechanic</option>
                        <option value="2">Automat</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="color">Color</label>
                    <select class="form-control" id="color">
                        <option value="1">Black</option>
                        <option value="2">Gray</option>
                        <option value="3">Green</option>
                        <option value="4">Yellow</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="low">Low cost</label>
                    <input type="text" id="low" name="low" class="form-control"/>
                    <label for="high">High cost</label>
                    <input type="text" id="high" name="high" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="photo">Load a photo</label>
                    <input id="photo" name="photo" type="file" class="file"/>
                </div>
                <button type="submit" class="btn btn-default btn-primary">Give an advert!</button>
            </form>
        </div>
        <div class="col-sm"></div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>

</div>
</body>
</html>
