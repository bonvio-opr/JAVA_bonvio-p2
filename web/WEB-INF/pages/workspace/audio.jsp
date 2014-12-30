<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 30.12.2014
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Old School Cassette Player with HTML5 Audio</title>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="Codrops" />
  <link rel="stylesheet" type="text/css" href="/CM/resources/workspace/audio/css/demo.css" />
  <link rel="stylesheet" type="text/css" href="/CM/resources/workspace/audio/css/style.css" />
  <link rel="stylesheet" type="text/css" href="/CM/resources/workspace/audio/css/knobKnob.css" />
  <link href='http://fonts.googleapis.com/css?family=Aldrich' rel='stylesheet' type='text/css' />
  <script type="text/javascript" src="/CM/resources/workspace/audio/js/modernizr.custom.69142.js"></script>
</head>
<body>
<div class="container">
  <div id="vc-container" class="vc-container">
    <div class="vc-tape-wrapper">
      <div class="vc-tape">
        <div class="vc-tape-back">
          <div class="vc-tape-wheel vc-tape-wheel-left"><div></div></div>
          <div class="vc-tape-wheel vc-tape-wheel-right"><div></div></div>
        </div>
        <div class="vc-tape-front vc-tape-side-a">
          <span>A</span>
        </div>
        <div class="vc-tape-front vc-tape-side-b">
          <span>B</span>
        </div>
      </div>
    </div>
    <div class="vc-loader"></div>
  </div><!-- //vc-container -->
</div><!-- //container -->

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<!-- KnobKnob by Martin Angelov : https://github.com/martinaglv/KnobKnob -->
<script src="/CM/resources/workspace/audio/js/transform.js"></script>
<script src="/CM/resources/workspace/audio/js/knobKnob.jquery.js"></script>

<script type="text/javascript" src="/CM/resources/workspace/audio/js/jquery.cassette.js"></script>
<script type="text/javascript">
  $(function() {

    $( '#vc-container' ).cassette();

  });
</script>
</body>
</html>
