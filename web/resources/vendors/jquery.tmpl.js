




<!DOCTYPE html>
<html class="   ">
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# object: http://ogp.me/ns/object# article: http://ogp.me/ns/article# profile: http://ogp.me/ns/profile#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    
    <title>jquery-tmpl/jquery.tmpl.js at master · BorisMoore/jquery-tmpl</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <meta property="fb:app_id" content="1401488693436528"/>

      <meta content="@github" name="twitter:site" /><meta content="summary" name="twitter:card" /><meta content="BorisMoore/jquery-tmpl" name="twitter:title" /><meta content="jquery-tmpl - The original official jQuery Templates plugin. This project was maintained by the jQuery team as an official jQuery plugin. It is no longer in active development, and will be superseded " name="twitter:description" /><meta content="https://avatars2.githubusercontent.com/u/202658?s=400" name="twitter:image:src" />
<meta content="GitHub" property="og:site_name" /><meta content="object" property="og:type" /><meta content="https://avatars2.githubusercontent.com/u/202658?s=400" property="og:image" /><meta content="BorisMoore/jquery-tmpl" property="og:title" /><meta content="https://github.com/BorisMoore/jquery-tmpl" property="og:url" /><meta content="jquery-tmpl - The original official jQuery Templates plugin. This project was maintained by the jQuery team as an official jQuery plugin. It is no longer in active development, and will be superseded by JsRender." property="og:description" />

    <link rel="assets" href="https://github.global.ssl.fastly.net/">
    <link rel="conduit-xhr" href="https://ghconduit.com:25035/">
    <link rel="xhr-socket" href="/_sockets" />

    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="collector-cdn.github.com" name="octolytics-script-host" /><meta content="github" name="octolytics-app-id" /><meta content="5388F24A:44A9:AD902D:535F4D08" name="octolytics-dimension-request_id" /><meta content="1687618" name="octolytics-actor-id" /><meta content="Arti88" name="octolytics-actor-login" /><meta content="02e072b196ca4b29dc4aeeda55844bace718baf0eb4b6335f072f23eba48c21f" name="octolytics-actor-hash" />
    

    
    
    <link rel="icon" type="image/x-icon" href="https://github.global.ssl.fastly.net/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="hiGjkdojkU708KAtNbcZFt1rc8nmsX5dDAO0aV4SZZcDHfPNobO2/NfXBRkHCdyBydZOygD3jeZP0nYW1X6aXw==" name="csrf-token" />

    <link href="https://github.global.ssl.fastly.net/assets/github-fd636fc0fc23c06849cc029659840d67838291b9.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://github.global.ssl.fastly.net/assets/github2-58c3c753e85f04c56dceaef99f1a5424de206911.css" media="all" rel="stylesheet" type="text/css" />
    


        <script crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/frameworks-83bb02a73dd69926304fd1a101dbd75aa669e8dd.js" type="text/javascript"></script>
        <script async="async" crossorigin="anonymous" src="https://github.global.ssl.fastly.net/assets/github-1d047edcc09cf920d198765a63e62ffd3432c6f7.js" type="text/javascript"></script>
        
        
      <meta http-equiv="x-pjax-version" content="134013d2d6246e3fcef22ba957b35780">

        <link data-pjax-transient rel='permalink' href='/BorisMoore/jquery-tmpl/blob/b504c8afba9a0be6870a6989b20573373dff373e/jquery.tmpl.js'>

  <meta name="description" content="jquery-tmpl - The original official jQuery Templates plugin. This project was maintained by the jQuery team as an official jQuery plugin. It is no longer in active development, and will be superseded by JsRender." />

  <meta content="202658" name="octolytics-dimension-user_id" /><meta content="BorisMoore" name="octolytics-dimension-user_login" /><meta content="547820" name="octolytics-dimension-repository_id" /><meta content="BorisMoore/jquery-tmpl" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="547820" name="octolytics-dimension-repository_network_root_id" /><meta content="BorisMoore/jquery-tmpl" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/BorisMoore/jquery-tmpl/commits/master.atom" rel="alternate" title="Recent Commits to jquery-tmpl:master" type="application/atom+xml" />

  </head>


  <body class="logged_in  env-production windows vis-public page-blob">
    <a href="#start-of-content" tabindex="1" class="accessibility-aid js-skip-to-content">Skip to content</a>
    <div class="wrapper">
      
      
      
      


      <div class="header header-logged-in true">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/">
  <span class="mega-octicon octicon-mark-github"></span>
</a>

    
    <a href="/notifications" aria-label="You have unread notifications" class="notification-indicator tooltipped tooltipped-s" data-hotkey="g n">
        <span class="mail-status unread"></span>
</a>

      <div class="command-bar js-command-bar  in-repository">
          <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<div class="commandbar">
  <span class="message"></span>
  <input type="text" data-hotkey="s, /" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    data-username="Arti88"
      data-repo="BorisMoore/jquery-tmpl"
      data-branch="master"
      data-sha="51249e5038ce8c9eb25e8b42104f6ef66d15b4af"
  >
  <div class="display hidden"></div>
</div>

    <input type="hidden" name="nwo" value="BorisMoore/jquery-tmpl" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target" role="button" aria-haspopup="true">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container" aria-hidden="true">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="help tooltipped tooltipped-s" aria-label="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
        <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
            <li><a href="https://gist.github.com">Gist</a></li>
            <li><a href="/blog">Blog</a></li>
          <li><a href="https://help.github.com">Help</a></li>
        </ul>
      </div>

    


  <ul id="user-links">
    <li>
      <a href="/Arti88" class="name">
        <img alt="Arti Urskov" class=" js-avatar" data-user="1687618" height="20" src="https://avatars0.githubusercontent.com/u/1687618?s=140" width="20" /> Arti88
      </a>
    </li>

    <li class="new-menu dropdown-toggle js-menu-container">
      <a href="#" class="js-menu-target tooltipped tooltipped-s" aria-label="Create new...">
        <span class="octicon octicon-plus"></span>
        <span class="dropdown-arrow"></span>
      </a>

      <div class="new-menu-content js-menu-content">
      </div>
    </li>

    <li>
      <a href="/settings/profile" id="account_settings"
        class="tooltipped tooltipped-s"
        aria-label="Account settings ">
        <span class="octicon octicon-tools"></span>
      </a>
    </li>
    <li>
      <form class="logout-form" action="/logout" method="post">
        <button class="sign-out-button tooltipped tooltipped-s" aria-label="Sign out">
          <span class="octicon octicon-log-out"></span>
        </button>
      </form>
    </li>

  </ul>

<div class="js-new-dropdown-contents hidden">
  

<ul class="dropdown-menu">
  <li>
    <a href="/new"><span class="octicon octicon-repo-create"></span> New repository</a>
  </li>
  <li>
    <a href="/organizations/new"><span class="octicon octicon-organization"></span> New organization</a>
  </li>


    <li class="section-title">
      <span title="BorisMoore/jquery-tmpl">This repository</span>
    </li>
      <li>
        <a href="/BorisMoore/jquery-tmpl/issues/new"><span class="octicon octicon-issue-opened"></span> New issue</a>
      </li>
</ul>

</div>


    
  </div>
</div>

      

        



      <div id="start-of-content" class="accessibility-aid"></div>
          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    <div id="js-flash-container">
      
    </div>
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        

<ul class="pagehead-actions">

    <li class="subscription">
      <form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="LeaUxTvnsI4M0vTYNVIHChU+7/f2u1+Pwg1sEiPDONefmb/Mm9ldmgldJwXk4z24CKLXwzxp0QWHU0bKGYM/Iw==" /></div>  <input id="repository_id" name="repository_id" type="hidden" value="547820" />

    <div class="select-menu js-menu-container js-select-menu">
      <a class="social-count js-social-count" href="/BorisMoore/jquery-tmpl/watchers">
        104
      </a>
      <span class="minibutton select-menu-button with-count js-menu-target" role="button" tabindex="0" aria-haspopup="true">
        <span class="js-select-button">
          <span class="octicon octicon-eye-watch"></span>
          Watch
        </span>
      </span>

      <div class="select-menu-modal-holder">
        <div class="select-menu-modal subscription-menu-modal js-menu-content" aria-hidden="true">
          <div class="select-menu-header">
            <span class="select-menu-title">Notification status</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-list js-navigation-container" role="menu">

            <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input checked="checked" id="do_included" name="do" type="radio" value="included" />
                <h4>Not watching</h4>
                <span class="description">You only receive notifications for conversations in which you participate or are @mentioned.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-watch"></span>
                  Watch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_subscribed" name="do" type="radio" value="subscribed" />
                <h4>Watching</h4>
                <span class="description">You receive notifications for all conversations in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-unwatch"></span>
                  Unwatch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_ignore" name="do" type="radio" value="ignore" />
                <h4>Ignoring</h4>
                <span class="description">You do not receive any notifications for conversations in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-mute"></span>
                  Stop ignoring
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

</form>
    </li>

  <li>
  

  <div class="js-toggler-container js-social-container starring-container ">
    <a href="/BorisMoore/jquery-tmpl/unstar"
      class="minibutton with-count js-toggler-target star-button starred"
      aria-label="Unstar this repository" title="Unstar BorisMoore/jquery-tmpl" data-remote="true" data-method="post" rel="nofollow">
      <span class="octicon octicon-star-delete"></span><span class="text">Unstar</span>
    </a>

    <a href="/BorisMoore/jquery-tmpl/star"
      class="minibutton with-count js-toggler-target star-button unstarred"
      aria-label="Star this repository" title="Star BorisMoore/jquery-tmpl" data-remote="true" data-method="post" rel="nofollow">
      <span class="octicon octicon-star"></span><span class="text">Star</span>
    </a>

      <a class="social-count js-social-count" href="/BorisMoore/jquery-tmpl/stargazers">
        2,284
      </a>
  </div>

  </li>


        <li>
          <a href="/BorisMoore/jquery-tmpl/fork" class="minibutton with-count js-toggler-target fork-button lighter tooltipped-n" title="Fork your own copy of BorisMoore/jquery-tmpl to your account" aria-label="Fork your own copy of BorisMoore/jquery-tmpl to your account" rel="nofollow" data-method="post">
            <span class="octicon octicon-git-branch-create"></span><span class="text">Fork</span>
          </a>
          <a href="/BorisMoore/jquery-tmpl/network" class="social-count">615</a>
        </li>


</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
          <span class="repo-label"><span>public</span></span>
          <span class="mega-octicon octicon-repo"></span>
          <span class="author"><a href="/BorisMoore" class="url fn" itemprop="url" rel="author"><span itemprop="title">BorisMoore</span></a></span><!--
       --><span class="path-divider">/</span><!--
       --><strong><a href="/BorisMoore/jquery-tmpl" class="js-current-repository js-repo-home-link">jquery-tmpl</a></strong>

          <span class="page-context-loader">
            <img alt="Octocat-spinner-32" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">
      <div class="repository-with-sidebar repo-container new-discussion-timeline js-new-discussion-timeline  ">
        <div class="repository-sidebar clearfix">
            

<div class="sunken-menu vertical-right repo-nav js-repo-nav js-repository-container-pjax js-octicon-loaders">
  <div class="sunken-menu-contents">
    <ul class="sunken-menu-group">
      <li class="tooltipped tooltipped-w" aria-label="Code">
        <a href="/BorisMoore/jquery-tmpl" aria-label="Code" class="selected js-selected-navigation-item sunken-menu-item" data-hotkey="g c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /BorisMoore/jquery-tmpl">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped tooltipped-w" aria-label="Issues">
          <a href="/BorisMoore/jquery-tmpl/issues" aria-label="Issues" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-hotkey="g i" data-selected-links="repo_issues /BorisMoore/jquery-tmpl/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class='counter'>65</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped tooltipped-w" aria-label="Pull Requests">
        <a href="/BorisMoore/jquery-tmpl/pulls" aria-label="Pull Requests" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-hotkey="g p" data-selected-links="repo_pulls /BorisMoore/jquery-tmpl/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class='counter'>1</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


        <li class="tooltipped tooltipped-w" aria-label="Wiki">
          <a href="/BorisMoore/jquery-tmpl/wiki" aria-label="Wiki" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_wiki /BorisMoore/jquery-tmpl/wiki">
            <span class="octicon octicon-book"></span> <span class="full-word">Wiki</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>
    </ul>
    <div class="sunken-menu-separator"></div>
    <ul class="sunken-menu-group">

      <li class="tooltipped tooltipped-w" aria-label="Pulse">
        <a href="/BorisMoore/jquery-tmpl/pulse" aria-label="Pulse" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="pulse /BorisMoore/jquery-tmpl/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Graphs">
        <a href="/BorisMoore/jquery-tmpl/graphs" aria-label="Graphs" class="js-selected-navigation-item sunken-menu-item" data-pjax="true" data-selected-links="repo_graphs repo_contributors /BorisMoore/jquery-tmpl/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped tooltipped-w" aria-label="Network">
        <a href="/BorisMoore/jquery-tmpl/network" aria-label="Network" class="js-selected-navigation-item sunken-menu-item js-disable-pjax" data-selected-links="repo_network /BorisMoore/jquery-tmpl/network">
          <span class="octicon octicon-git-branch"></span> <span class="full-word">Network</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


  </div>
</div>

              <div class="only-with-full-nav">
                

  

<div class="clone-url open"
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=clone">
  <h3><strong>HTTPS</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/BorisMoore/jquery-tmpl.git" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/BorisMoore/jquery-tmpl.git" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="ssh"
  data-url="/users/set_protocol?protocol_selector=ssh&amp;protocol_type=clone">
  <h3><strong>SSH</strong> clone URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="git@github.com:BorisMoore/jquery-tmpl.git" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="git@github.com:BorisMoore/jquery-tmpl.git" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=clone">
  <h3><strong>Subversion</strong> checkout URL</h3>
  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/BorisMoore/jquery-tmpl" readonly="readonly">

    <span aria-label="copy to clipboard" class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/BorisMoore/jquery-tmpl" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


<p class="clone-options">You can clone with
      <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>,
      <a href="#" class="js-clone-selector" data-protocol="ssh">SSH</a>,
      or <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>.
  <span class="help tooltipped tooltipped-n" aria-label="Get help on which URL is right for you.">
    <a href="https://help.github.com/articles/which-remote-url-should-i-use">
    <span class="octicon octicon-question"></span>
    </a>
  </span>
</p>


  <a href="http://windows.github.com" class="minibutton sidebar-button" title="Save BorisMoore/jquery-tmpl to your computer and use it in GitHub Desktop." aria-label="Save BorisMoore/jquery-tmpl to your computer and use it in GitHub Desktop.">
    <span class="octicon octicon-device-desktop"></span>
    Clone in Desktop
  </a>

                <a href="/BorisMoore/jquery-tmpl/archive/master.zip"
                   class="minibutton sidebar-button"
                   aria-label="Download BorisMoore/jquery-tmpl as a zip file"
                   title="Download BorisMoore/jquery-tmpl as a zip file"
                   rel="nofollow">
                  <span class="octicon octicon-cloud-download"></span>
                  Download ZIP
                </a>
              </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:914586eaf8e29ef15a3227e3e6084eb7 -->

<p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

<a href="/BorisMoore/jquery-tmpl/find/master" data-pjax data-hotkey="t" class="js-show-file-finder" style="display:none">Show File Finder</a>

<div class="file-navigation">
  

<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target" data-hotkey="w"
    data-master-branch="master"
    data-ref="master"
    role="button" aria-label="Switch branches or tags" tabindex="0" aria-haspopup="true">
    <span class="octicon octicon-git-branch"></span>
    <i>branch:</i>
    <span class="js-select-button">master</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax aria-hidden="true">

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-remove-close js-menu-close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Filter branches/tags" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Filter branches/tags">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/BorisMoore/jquery-tmpl/blob/gh-pages/jquery.tmpl.js"
                 data-name="gh-pages"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="gh-pages">gh-pages</a>
            </div> <!-- /.select-menu-item -->
            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/BorisMoore/jquery-tmpl/blob/master/jquery.tmpl.js"
                 data-name="master"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/BorisMoore/jquery-tmpl/tree/vBeta1.0.0/jquery.tmpl.js"
                 data-name="vBeta1.0.0"
                 data-skip-pjax="true"
                 rel="nofollow"
                 class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target"
                 title="vBeta1.0.0">vBeta1.0.0</a>
            </div> <!-- /.select-menu-item -->
        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/BorisMoore/jquery-tmpl" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">jquery-tmpl</span></a></span></span><span class="separator"> / </span><strong class="final-path">jquery.tmpl.js</strong> <span aria-label="copy to clipboard" class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="jquery.tmpl.js" data-copied-hint="copied!"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


  <div class="commit file-history-tease">
    <img alt="Richard D. Worth" class="main-avatar js-avatar" data-user="107824" height="24" src="https://avatars2.githubusercontent.com/u/107824?s=140" width="24" />
    <span class="author"><a href="/rdworth" rel="author">rdworth</a></span>
    <time class="js-relative-date" data-title-format="YYYY-MM-DD HH:mm:ss" datetime="2012-01-31T09:08:03-05:00" title="2012-01-31 14:08:03">January 31, 2012</time>
    <div class="commit-title">
        <a href="/BorisMoore/jquery-tmpl/commit/21d2a8f3b3ad5c2e09548558be8d3005352b70c4" class="message" data-pjax="true" title="Added copyright year to headers">Added copyright year to headers</a>
    </div>

    <div class="participation">
      <p class="quickstat"><a href="#blob_contributors_box" rel="facebox"><strong>4</strong>  contributors</a></p>
          <a class="avatar tooltipped tooltipped-s" aria-label="BorisMoore" href="/BorisMoore/jquery-tmpl/commits/master/jquery.tmpl.js?author=BorisMoore"><img alt="Boris Moore" class=" js-avatar" data-user="202658" height="20" src="https://avatars1.githubusercontent.com/u/202658?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="jeresig" href="/BorisMoore/jquery-tmpl/commits/master/jquery.tmpl.js?author=jeresig"><img alt="John Resig" class=" js-avatar" data-user="1615" height="20" src="https://avatars0.githubusercontent.com/u/1615?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="hoganlong" href="/BorisMoore/jquery-tmpl/commits/master/jquery.tmpl.js?author=hoganlong"><img alt="Hogan Long" class=" js-avatar" data-user="192723" height="20" src="https://avatars0.githubusercontent.com/u/192723?s=140" width="20" /></a>
    <a class="avatar tooltipped tooltipped-s" aria-label="rdworth" href="/BorisMoore/jquery-tmpl/commits/master/jquery.tmpl.js?author=rdworth"><img alt="Richard D. Worth" class=" js-avatar" data-user="107824" height="20" src="https://avatars2.githubusercontent.com/u/107824?s=140" width="20" /></a>


    </div>
    <div id="blob_contributors_box" style="display:none">
      <h2 class="facebox-header">Users who have contributed to this file</h2>
      <ul class="facebox-user-list">
          <li class="facebox-user-list-item">
            <img alt="Boris Moore" class=" js-avatar" data-user="202658" height="24" src="https://avatars1.githubusercontent.com/u/202658?s=140" width="24" />
            <a href="/BorisMoore">BorisMoore</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="John Resig" class=" js-avatar" data-user="1615" height="24" src="https://avatars0.githubusercontent.com/u/1615?s=140" width="24" />
            <a href="/jeresig">jeresig</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="Hogan Long" class=" js-avatar" data-user="192723" height="24" src="https://avatars0.githubusercontent.com/u/192723?s=140" width="24" />
            <a href="/hoganlong">hoganlong</a>
          </li>
          <li class="facebox-user-list-item">
            <img alt="Richard D. Worth" class=" js-avatar" data-user="107824" height="24" src="https://avatars2.githubusercontent.com/u/107824?s=140" width="24" />
            <a href="/rdworth">rdworth</a>
          </li>
      </ul>
    </div>
  </div>

<div class="file-box">
  <div class="file">
    <div class="meta clearfix">
      <div class="info file-name">
        <span class="icon"><b class="octicon octicon-file-text"></b></span>
        <span class="mode" title="File Mode">file</span>
        <span class="meta-divider"></span>
          <span>485 lines (450 sloc)</span>
          <span class="meta-divider"></span>
        <span>19.093 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
            <a class="minibutton tooltipped tooltipped-w"
               href="http://windows.github.com" aria-label="Open this file in GitHub for Windows">
                <span class="octicon octicon-device-desktop"></span> Open
            </a>
                <a class="minibutton tooltipped tooltipped-n js-update-url-with-hash"
                   aria-label="Clicking this button will automatically fork this project so you can edit the file"
                   href="/BorisMoore/jquery-tmpl/edit/master/jquery.tmpl.js"
                   data-method="post" rel="nofollow">Edit</a>
          <a href="/BorisMoore/jquery-tmpl/raw/master/jquery.tmpl.js" class="button minibutton " id="raw-url">Raw</a>
            <a href="/BorisMoore/jquery-tmpl/blame/master/jquery.tmpl.js" class="button minibutton js-update-url-with-hash">Blame</a>
          <a href="/BorisMoore/jquery-tmpl/commits/master/jquery.tmpl.js" class="button minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->

            <a class="minibutton danger empty-icon tooltipped tooltipped-s"
               href="/BorisMoore/jquery-tmpl/delete/master/jquery.tmpl.js"
               aria-label="Fork this project and delete file"
               data-method="post" data-test-id="delete-blob-file" rel="nofollow">

          Delete
        </a>
      </div><!-- /.actions -->
    </div>
        <div class="blob-wrapper data type-javascript js-blob-data">
        <table class="file-code file-diff tab-size-8">
          <tr class="file-code-line">
            <td class="blob-line-nums">
              <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>
<span id="L201" rel="#L201">201</span>
<span id="L202" rel="#L202">202</span>
<span id="L203" rel="#L203">203</span>
<span id="L204" rel="#L204">204</span>
<span id="L205" rel="#L205">205</span>
<span id="L206" rel="#L206">206</span>
<span id="L207" rel="#L207">207</span>
<span id="L208" rel="#L208">208</span>
<span id="L209" rel="#L209">209</span>
<span id="L210" rel="#L210">210</span>
<span id="L211" rel="#L211">211</span>
<span id="L212" rel="#L212">212</span>
<span id="L213" rel="#L213">213</span>
<span id="L214" rel="#L214">214</span>
<span id="L215" rel="#L215">215</span>
<span id="L216" rel="#L216">216</span>
<span id="L217" rel="#L217">217</span>
<span id="L218" rel="#L218">218</span>
<span id="L219" rel="#L219">219</span>
<span id="L220" rel="#L220">220</span>
<span id="L221" rel="#L221">221</span>
<span id="L222" rel="#L222">222</span>
<span id="L223" rel="#L223">223</span>
<span id="L224" rel="#L224">224</span>
<span id="L225" rel="#L225">225</span>
<span id="L226" rel="#L226">226</span>
<span id="L227" rel="#L227">227</span>
<span id="L228" rel="#L228">228</span>
<span id="L229" rel="#L229">229</span>
<span id="L230" rel="#L230">230</span>
<span id="L231" rel="#L231">231</span>
<span id="L232" rel="#L232">232</span>
<span id="L233" rel="#L233">233</span>
<span id="L234" rel="#L234">234</span>
<span id="L235" rel="#L235">235</span>
<span id="L236" rel="#L236">236</span>
<span id="L237" rel="#L237">237</span>
<span id="L238" rel="#L238">238</span>
<span id="L239" rel="#L239">239</span>
<span id="L240" rel="#L240">240</span>
<span id="L241" rel="#L241">241</span>
<span id="L242" rel="#L242">242</span>
<span id="L243" rel="#L243">243</span>
<span id="L244" rel="#L244">244</span>
<span id="L245" rel="#L245">245</span>
<span id="L246" rel="#L246">246</span>
<span id="L247" rel="#L247">247</span>
<span id="L248" rel="#L248">248</span>
<span id="L249" rel="#L249">249</span>
<span id="L250" rel="#L250">250</span>
<span id="L251" rel="#L251">251</span>
<span id="L252" rel="#L252">252</span>
<span id="L253" rel="#L253">253</span>
<span id="L254" rel="#L254">254</span>
<span id="L255" rel="#L255">255</span>
<span id="L256" rel="#L256">256</span>
<span id="L257" rel="#L257">257</span>
<span id="L258" rel="#L258">258</span>
<span id="L259" rel="#L259">259</span>
<span id="L260" rel="#L260">260</span>
<span id="L261" rel="#L261">261</span>
<span id="L262" rel="#L262">262</span>
<span id="L263" rel="#L263">263</span>
<span id="L264" rel="#L264">264</span>
<span id="L265" rel="#L265">265</span>
<span id="L266" rel="#L266">266</span>
<span id="L267" rel="#L267">267</span>
<span id="L268" rel="#L268">268</span>
<span id="L269" rel="#L269">269</span>
<span id="L270" rel="#L270">270</span>
<span id="L271" rel="#L271">271</span>
<span id="L272" rel="#L272">272</span>
<span id="L273" rel="#L273">273</span>
<span id="L274" rel="#L274">274</span>
<span id="L275" rel="#L275">275</span>
<span id="L276" rel="#L276">276</span>
<span id="L277" rel="#L277">277</span>
<span id="L278" rel="#L278">278</span>
<span id="L279" rel="#L279">279</span>
<span id="L280" rel="#L280">280</span>
<span id="L281" rel="#L281">281</span>
<span id="L282" rel="#L282">282</span>
<span id="L283" rel="#L283">283</span>
<span id="L284" rel="#L284">284</span>
<span id="L285" rel="#L285">285</span>
<span id="L286" rel="#L286">286</span>
<span id="L287" rel="#L287">287</span>
<span id="L288" rel="#L288">288</span>
<span id="L289" rel="#L289">289</span>
<span id="L290" rel="#L290">290</span>
<span id="L291" rel="#L291">291</span>
<span id="L292" rel="#L292">292</span>
<span id="L293" rel="#L293">293</span>
<span id="L294" rel="#L294">294</span>
<span id="L295" rel="#L295">295</span>
<span id="L296" rel="#L296">296</span>
<span id="L297" rel="#L297">297</span>
<span id="L298" rel="#L298">298</span>
<span id="L299" rel="#L299">299</span>
<span id="L300" rel="#L300">300</span>
<span id="L301" rel="#L301">301</span>
<span id="L302" rel="#L302">302</span>
<span id="L303" rel="#L303">303</span>
<span id="L304" rel="#L304">304</span>
<span id="L305" rel="#L305">305</span>
<span id="L306" rel="#L306">306</span>
<span id="L307" rel="#L307">307</span>
<span id="L308" rel="#L308">308</span>
<span id="L309" rel="#L309">309</span>
<span id="L310" rel="#L310">310</span>
<span id="L311" rel="#L311">311</span>
<span id="L312" rel="#L312">312</span>
<span id="L313" rel="#L313">313</span>
<span id="L314" rel="#L314">314</span>
<span id="L315" rel="#L315">315</span>
<span id="L316" rel="#L316">316</span>
<span id="L317" rel="#L317">317</span>
<span id="L318" rel="#L318">318</span>
<span id="L319" rel="#L319">319</span>
<span id="L320" rel="#L320">320</span>
<span id="L321" rel="#L321">321</span>
<span id="L322" rel="#L322">322</span>
<span id="L323" rel="#L323">323</span>
<span id="L324" rel="#L324">324</span>
<span id="L325" rel="#L325">325</span>
<span id="L326" rel="#L326">326</span>
<span id="L327" rel="#L327">327</span>
<span id="L328" rel="#L328">328</span>
<span id="L329" rel="#L329">329</span>
<span id="L330" rel="#L330">330</span>
<span id="L331" rel="#L331">331</span>
<span id="L332" rel="#L332">332</span>
<span id="L333" rel="#L333">333</span>
<span id="L334" rel="#L334">334</span>
<span id="L335" rel="#L335">335</span>
<span id="L336" rel="#L336">336</span>
<span id="L337" rel="#L337">337</span>
<span id="L338" rel="#L338">338</span>
<span id="L339" rel="#L339">339</span>
<span id="L340" rel="#L340">340</span>
<span id="L341" rel="#L341">341</span>
<span id="L342" rel="#L342">342</span>
<span id="L343" rel="#L343">343</span>
<span id="L344" rel="#L344">344</span>
<span id="L345" rel="#L345">345</span>
<span id="L346" rel="#L346">346</span>
<span id="L347" rel="#L347">347</span>
<span id="L348" rel="#L348">348</span>
<span id="L349" rel="#L349">349</span>
<span id="L350" rel="#L350">350</span>
<span id="L351" rel="#L351">351</span>
<span id="L352" rel="#L352">352</span>
<span id="L353" rel="#L353">353</span>
<span id="L354" rel="#L354">354</span>
<span id="L355" rel="#L355">355</span>
<span id="L356" rel="#L356">356</span>
<span id="L357" rel="#L357">357</span>
<span id="L358" rel="#L358">358</span>
<span id="L359" rel="#L359">359</span>
<span id="L360" rel="#L360">360</span>
<span id="L361" rel="#L361">361</span>
<span id="L362" rel="#L362">362</span>
<span id="L363" rel="#L363">363</span>
<span id="L364" rel="#L364">364</span>
<span id="L365" rel="#L365">365</span>
<span id="L366" rel="#L366">366</span>
<span id="L367" rel="#L367">367</span>
<span id="L368" rel="#L368">368</span>
<span id="L369" rel="#L369">369</span>
<span id="L370" rel="#L370">370</span>
<span id="L371" rel="#L371">371</span>
<span id="L372" rel="#L372">372</span>
<span id="L373" rel="#L373">373</span>
<span id="L374" rel="#L374">374</span>
<span id="L375" rel="#L375">375</span>
<span id="L376" rel="#L376">376</span>
<span id="L377" rel="#L377">377</span>
<span id="L378" rel="#L378">378</span>
<span id="L379" rel="#L379">379</span>
<span id="L380" rel="#L380">380</span>
<span id="L381" rel="#L381">381</span>
<span id="L382" rel="#L382">382</span>
<span id="L383" rel="#L383">383</span>
<span id="L384" rel="#L384">384</span>
<span id="L385" rel="#L385">385</span>
<span id="L386" rel="#L386">386</span>
<span id="L387" rel="#L387">387</span>
<span id="L388" rel="#L388">388</span>
<span id="L389" rel="#L389">389</span>
<span id="L390" rel="#L390">390</span>
<span id="L391" rel="#L391">391</span>
<span id="L392" rel="#L392">392</span>
<span id="L393" rel="#L393">393</span>
<span id="L394" rel="#L394">394</span>
<span id="L395" rel="#L395">395</span>
<span id="L396" rel="#L396">396</span>
<span id="L397" rel="#L397">397</span>
<span id="L398" rel="#L398">398</span>
<span id="L399" rel="#L399">399</span>
<span id="L400" rel="#L400">400</span>
<span id="L401" rel="#L401">401</span>
<span id="L402" rel="#L402">402</span>
<span id="L403" rel="#L403">403</span>
<span id="L404" rel="#L404">404</span>
<span id="L405" rel="#L405">405</span>
<span id="L406" rel="#L406">406</span>
<span id="L407" rel="#L407">407</span>
<span id="L408" rel="#L408">408</span>
<span id="L409" rel="#L409">409</span>
<span id="L410" rel="#L410">410</span>
<span id="L411" rel="#L411">411</span>
<span id="L412" rel="#L412">412</span>
<span id="L413" rel="#L413">413</span>
<span id="L414" rel="#L414">414</span>
<span id="L415" rel="#L415">415</span>
<span id="L416" rel="#L416">416</span>
<span id="L417" rel="#L417">417</span>
<span id="L418" rel="#L418">418</span>
<span id="L419" rel="#L419">419</span>
<span id="L420" rel="#L420">420</span>
<span id="L421" rel="#L421">421</span>
<span id="L422" rel="#L422">422</span>
<span id="L423" rel="#L423">423</span>
<span id="L424" rel="#L424">424</span>
<span id="L425" rel="#L425">425</span>
<span id="L426" rel="#L426">426</span>
<span id="L427" rel="#L427">427</span>
<span id="L428" rel="#L428">428</span>
<span id="L429" rel="#L429">429</span>
<span id="L430" rel="#L430">430</span>
<span id="L431" rel="#L431">431</span>
<span id="L432" rel="#L432">432</span>
<span id="L433" rel="#L433">433</span>
<span id="L434" rel="#L434">434</span>
<span id="L435" rel="#L435">435</span>
<span id="L436" rel="#L436">436</span>
<span id="L437" rel="#L437">437</span>
<span id="L438" rel="#L438">438</span>
<span id="L439" rel="#L439">439</span>
<span id="L440" rel="#L440">440</span>
<span id="L441" rel="#L441">441</span>
<span id="L442" rel="#L442">442</span>
<span id="L443" rel="#L443">443</span>
<span id="L444" rel="#L444">444</span>
<span id="L445" rel="#L445">445</span>
<span id="L446" rel="#L446">446</span>
<span id="L447" rel="#L447">447</span>
<span id="L448" rel="#L448">448</span>
<span id="L449" rel="#L449">449</span>
<span id="L450" rel="#L450">450</span>
<span id="L451" rel="#L451">451</span>
<span id="L452" rel="#L452">452</span>
<span id="L453" rel="#L453">453</span>
<span id="L454" rel="#L454">454</span>
<span id="L455" rel="#L455">455</span>
<span id="L456" rel="#L456">456</span>
<span id="L457" rel="#L457">457</span>
<span id="L458" rel="#L458">458</span>
<span id="L459" rel="#L459">459</span>
<span id="L460" rel="#L460">460</span>
<span id="L461" rel="#L461">461</span>
<span id="L462" rel="#L462">462</span>
<span id="L463" rel="#L463">463</span>
<span id="L464" rel="#L464">464</span>
<span id="L465" rel="#L465">465</span>
<span id="L466" rel="#L466">466</span>
<span id="L467" rel="#L467">467</span>
<span id="L468" rel="#L468">468</span>
<span id="L469" rel="#L469">469</span>
<span id="L470" rel="#L470">470</span>
<span id="L471" rel="#L471">471</span>
<span id="L472" rel="#L472">472</span>
<span id="L473" rel="#L473">473</span>
<span id="L474" rel="#L474">474</span>
<span id="L475" rel="#L475">475</span>
<span id="L476" rel="#L476">476</span>
<span id="L477" rel="#L477">477</span>
<span id="L478" rel="#L478">478</span>
<span id="L479" rel="#L479">479</span>
<span id="L480" rel="#L480">480</span>
<span id="L481" rel="#L481">481</span>
<span id="L482" rel="#L482">482</span>
<span id="L483" rel="#L483">483</span>
<span id="L484" rel="#L484">484</span>

            </td>
            <td class="blob-line-code"><div class="code-body highlight"><pre><div class='line' id='LC1'><span class="cm">/*!</span></div><div class='line' id='LC2'><span class="cm"> * jQuery Templates Plugin 1.0.0pre</span></div><div class='line' id='LC3'><span class="cm"> * http://github.com/jquery/jquery-tmpl</span></div><div class='line' id='LC4'><span class="cm"> * Requires jQuery 1.4.2</span></div><div class='line' id='LC5'><span class="cm"> *</span></div><div class='line' id='LC6'><span class="cm"> * Copyright 2011, Software Freedom Conservancy, Inc.</span></div><div class='line' id='LC7'><span class="cm"> * Dual licensed under the MIT or GPL Version 2 licenses.</span></div><div class='line' id='LC8'><span class="cm"> * http://jquery.org/license</span></div><div class='line' id='LC9'><span class="cm"> */</span></div><div class='line' id='LC10'><span class="p">(</span><span class="kd">function</span><span class="p">(</span> <span class="nx">jQuery</span><span class="p">,</span> <span class="kc">undefined</span> <span class="p">){</span></div><div class='line' id='LC11'>	<span class="kd">var</span> <span class="nx">oldManip</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">domManip</span><span class="p">,</span> <span class="nx">tmplItmAtt</span> <span class="o">=</span> <span class="s2">&quot;_tmplitem&quot;</span><span class="p">,</span> <span class="nx">htmlExpr</span> <span class="o">=</span> <span class="sr">/^[^&lt;]*(&lt;[\w\W]+&gt;)[^&gt;]*$|\{\{\! /</span><span class="p">,</span></div><div class='line' id='LC12'>		<span class="nx">newTmplItems</span> <span class="o">=</span> <span class="p">{},</span> <span class="nx">wrappedItems</span> <span class="o">=</span> <span class="p">{},</span> <span class="nx">appendToTmplItems</span><span class="p">,</span> <span class="nx">topTmplItem</span> <span class="o">=</span> <span class="p">{</span> <span class="nx">key</span><span class="o">:</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">data</span><span class="o">:</span> <span class="p">{}</span> <span class="p">},</span> <span class="nx">itemKey</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">cloneIndex</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">stack</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC13'><br/></div><div class='line' id='LC14'>	<span class="kd">function</span> <span class="nx">newTmplItem</span><span class="p">(</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">parentItem</span><span class="p">,</span> <span class="nx">fn</span><span class="p">,</span> <span class="nx">data</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC15'>		<span class="c1">// Returns a template item data structure for a new rendered instance of a template (a &#39;template item&#39;).</span></div><div class='line' id='LC16'>		<span class="c1">// The content field is a hierarchical array of strings and nested items (to be</span></div><div class='line' id='LC17'>		<span class="c1">// removed and replaced by nodes field of dom elements, once inserted in DOM).</span></div><div class='line' id='LC18'>		<span class="kd">var</span> <span class="nx">newItem</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC19'>			<span class="nx">data</span><span class="o">:</span> <span class="nx">data</span> <span class="o">||</span> <span class="p">(</span><span class="nx">data</span> <span class="o">===</span> <span class="mi">0</span> <span class="o">||</span> <span class="nx">data</span> <span class="o">===</span> <span class="kc">false</span><span class="p">)</span> <span class="o">?</span> <span class="nx">data</span> <span class="o">:</span> <span class="p">(</span><span class="nx">parentItem</span> <span class="o">?</span> <span class="nx">parentItem</span><span class="p">.</span><span class="nx">data</span> <span class="o">:</span> <span class="p">{}),</span></div><div class='line' id='LC20'>			<span class="nx">_wrap</span><span class="o">:</span> <span class="nx">parentItem</span> <span class="o">?</span> <span class="nx">parentItem</span><span class="p">.</span><span class="nx">_wrap</span> <span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC21'>			<span class="nx">tmpl</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC22'>			<span class="nx">parent</span><span class="o">:</span> <span class="nx">parentItem</span> <span class="o">||</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC23'>			<span class="nx">nodes</span><span class="o">:</span> <span class="p">[],</span></div><div class='line' id='LC24'>			<span class="nx">calls</span><span class="o">:</span> <span class="nx">tiCalls</span><span class="p">,</span></div><div class='line' id='LC25'>			<span class="nx">nest</span><span class="o">:</span> <span class="nx">tiNest</span><span class="p">,</span></div><div class='line' id='LC26'>			<span class="nx">wrap</span><span class="o">:</span> <span class="nx">tiWrap</span><span class="p">,</span></div><div class='line' id='LC27'>			<span class="nx">html</span><span class="o">:</span> <span class="nx">tiHtml</span><span class="p">,</span></div><div class='line' id='LC28'>			<span class="nx">update</span><span class="o">:</span> <span class="nx">tiUpdate</span></div><div class='line' id='LC29'>		<span class="p">};</span></div><div class='line' id='LC30'>		<span class="k">if</span> <span class="p">(</span> <span class="nx">options</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC31'>			<span class="nx">jQuery</span><span class="p">.</span><span class="nx">extend</span><span class="p">(</span> <span class="nx">newItem</span><span class="p">,</span> <span class="nx">options</span><span class="p">,</span> <span class="p">{</span> <span class="nx">nodes</span><span class="o">:</span> <span class="p">[],</span> <span class="nx">parent</span><span class="o">:</span> <span class="nx">parentItem</span> <span class="p">});</span></div><div class='line' id='LC32'>		<span class="p">}</span></div><div class='line' id='LC33'>		<span class="k">if</span> <span class="p">(</span> <span class="nx">fn</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC34'>			<span class="c1">// Build the hierarchical content to be used during insertion into DOM</span></div><div class='line' id='LC35'>			<span class="nx">newItem</span><span class="p">.</span><span class="nx">tmpl</span> <span class="o">=</span> <span class="nx">fn</span><span class="p">;</span></div><div class='line' id='LC36'>			<span class="nx">newItem</span><span class="p">.</span><span class="nx">_ctnt</span> <span class="o">=</span> <span class="nx">newItem</span><span class="p">.</span><span class="nx">_ctnt</span> <span class="o">||</span> <span class="nx">newItem</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">(</span> <span class="nx">jQuery</span><span class="p">,</span> <span class="nx">newItem</span> <span class="p">);</span></div><div class='line' id='LC37'>			<span class="nx">newItem</span><span class="p">.</span><span class="nx">key</span> <span class="o">=</span> <span class="o">++</span><span class="nx">itemKey</span><span class="p">;</span></div><div class='line' id='LC38'>			<span class="c1">// Keep track of new template item, until it is stored as jQuery Data on DOM element</span></div><div class='line' id='LC39'>			<span class="p">(</span><span class="nx">stack</span><span class="p">.</span><span class="nx">length</span> <span class="o">?</span> <span class="nx">wrappedItems</span> <span class="o">:</span> <span class="nx">newTmplItems</span><span class="p">)[</span><span class="nx">itemKey</span><span class="p">]</span> <span class="o">=</span> <span class="nx">newItem</span><span class="p">;</span></div><div class='line' id='LC40'>		<span class="p">}</span></div><div class='line' id='LC41'>		<span class="k">return</span> <span class="nx">newItem</span><span class="p">;</span></div><div class='line' id='LC42'>	<span class="p">}</span></div><div class='line' id='LC43'><br/></div><div class='line' id='LC44'>	<span class="c1">// Override appendTo etc., in order to provide support for targeting multiple elements. (This code would disappear if integrated in jquery core).</span></div><div class='line' id='LC45'>	<span class="nx">jQuery</span><span class="p">.</span><span class="nx">each</span><span class="p">({</span></div><div class='line' id='LC46'>		<span class="nx">appendTo</span><span class="o">:</span> <span class="s2">&quot;append&quot;</span><span class="p">,</span></div><div class='line' id='LC47'>		<span class="nx">prependTo</span><span class="o">:</span> <span class="s2">&quot;prepend&quot;</span><span class="p">,</span></div><div class='line' id='LC48'>		<span class="nx">insertBefore</span><span class="o">:</span> <span class="s2">&quot;before&quot;</span><span class="p">,</span></div><div class='line' id='LC49'>		<span class="nx">insertAfter</span><span class="o">:</span> <span class="s2">&quot;after&quot;</span><span class="p">,</span></div><div class='line' id='LC50'>		<span class="nx">replaceAll</span><span class="o">:</span> <span class="s2">&quot;replaceWith&quot;</span></div><div class='line' id='LC51'>	<span class="p">},</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">name</span><span class="p">,</span> <span class="nx">original</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC52'>		<span class="nx">jQuery</span><span class="p">.</span><span class="nx">fn</span><span class="p">[</span> <span class="nx">name</span> <span class="p">]</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">selector</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC53'>			<span class="kd">var</span> <span class="nx">ret</span> <span class="o">=</span> <span class="p">[],</span> <span class="nx">insert</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">(</span> <span class="nx">selector</span> <span class="p">),</span> <span class="nx">elems</span><span class="p">,</span> <span class="nx">i</span><span class="p">,</span> <span class="nx">l</span><span class="p">,</span> <span class="nx">tmplItems</span><span class="p">,</span></div><div class='line' id='LC54'>				<span class="nx">parent</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">length</span> <span class="o">===</span> <span class="mi">1</span> <span class="o">&amp;&amp;</span> <span class="k">this</span><span class="p">[</span><span class="mi">0</span><span class="p">].</span><span class="nx">parentNode</span><span class="p">;</span></div><div class='line' id='LC55'><br/></div><div class='line' id='LC56'>			<span class="nx">appendToTmplItems</span> <span class="o">=</span> <span class="nx">newTmplItems</span> <span class="o">||</span> <span class="p">{};</span></div><div class='line' id='LC57'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">parent</span> <span class="o">&amp;&amp;</span> <span class="nx">parent</span><span class="p">.</span><span class="nx">nodeType</span> <span class="o">===</span> <span class="mi">11</span> <span class="o">&amp;&amp;</span> <span class="nx">parent</span><span class="p">.</span><span class="nx">childNodes</span><span class="p">.</span><span class="nx">length</span> <span class="o">===</span> <span class="mi">1</span> <span class="o">&amp;&amp;</span> <span class="nx">insert</span><span class="p">.</span><span class="nx">length</span> <span class="o">===</span> <span class="mi">1</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC58'>				<span class="nx">insert</span><span class="p">[</span> <span class="nx">original</span> <span class="p">](</span> <span class="k">this</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="p">);</span></div><div class='line' id='LC59'>				<span class="nx">ret</span> <span class="o">=</span> <span class="k">this</span><span class="p">;</span></div><div class='line' id='LC60'>			<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC61'>				<span class="k">for</span> <span class="p">(</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">l</span> <span class="o">=</span> <span class="nx">insert</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">l</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC62'>					<span class="nx">cloneIndex</span> <span class="o">=</span> <span class="nx">i</span><span class="p">;</span></div><div class='line' id='LC63'>					<span class="nx">elems</span> <span class="o">=</span> <span class="p">(</span><span class="nx">i</span> <span class="o">&gt;</span> <span class="mi">0</span> <span class="o">?</span> <span class="k">this</span><span class="p">.</span><span class="nx">clone</span><span class="p">(</span><span class="kc">true</span><span class="p">)</span> <span class="o">:</span> <span class="k">this</span><span class="p">).</span><span class="nx">get</span><span class="p">();</span></div><div class='line' id='LC64'>					<span class="nx">jQuery</span><span class="p">(</span> <span class="nx">insert</span><span class="p">[</span><span class="nx">i</span><span class="p">]</span> <span class="p">)[</span> <span class="nx">original</span> <span class="p">](</span> <span class="nx">elems</span> <span class="p">);</span></div><div class='line' id='LC65'>					<span class="nx">ret</span> <span class="o">=</span> <span class="nx">ret</span><span class="p">.</span><span class="nx">concat</span><span class="p">(</span> <span class="nx">elems</span> <span class="p">);</span></div><div class='line' id='LC66'>				<span class="p">}</span></div><div class='line' id='LC67'>				<span class="nx">cloneIndex</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span></div><div class='line' id='LC68'>				<span class="nx">ret</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">pushStack</span><span class="p">(</span> <span class="nx">ret</span><span class="p">,</span> <span class="nx">name</span><span class="p">,</span> <span class="nx">insert</span><span class="p">.</span><span class="nx">selector</span> <span class="p">);</span></div><div class='line' id='LC69'>			<span class="p">}</span></div><div class='line' id='LC70'>			<span class="nx">tmplItems</span> <span class="o">=</span> <span class="nx">appendToTmplItems</span><span class="p">;</span></div><div class='line' id='LC71'>			<span class="nx">appendToTmplItems</span> <span class="o">=</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC72'>			<span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">.</span><span class="nx">complete</span><span class="p">(</span> <span class="nx">tmplItems</span> <span class="p">);</span></div><div class='line' id='LC73'>			<span class="k">return</span> <span class="nx">ret</span><span class="p">;</span></div><div class='line' id='LC74'>		<span class="p">};</span></div><div class='line' id='LC75'>	<span class="p">});</span></div><div class='line' id='LC76'><br/></div><div class='line' id='LC77'>	<span class="nx">jQuery</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC78'>		<span class="c1">// Use first wrapped element as template markup.</span></div><div class='line' id='LC79'>		<span class="c1">// Return wrapped set of template items, obtained by rendering template against data.</span></div><div class='line' id='LC80'>		<span class="nx">tmpl</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">data</span><span class="p">,</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">parentItem</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC81'>			<span class="k">return</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">(</span> <span class="k">this</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="nx">data</span><span class="p">,</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">parentItem</span> <span class="p">);</span></div><div class='line' id='LC82'>		<span class="p">},</span></div><div class='line' id='LC83'><br/></div><div class='line' id='LC84'>		<span class="c1">// Find which rendered template item the first wrapped DOM element belongs to</span></div><div class='line' id='LC85'>		<span class="nx">tmplItem</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC86'>			<span class="k">return</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmplItem</span><span class="p">(</span> <span class="k">this</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="p">);</span></div><div class='line' id='LC87'>		<span class="p">},</span></div><div class='line' id='LC88'><br/></div><div class='line' id='LC89'>		<span class="c1">// Consider the first wrapped element as a template declaration, and get the compiled template or store it as a named template.</span></div><div class='line' id='LC90'>		<span class="nx">template</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">name</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC91'>			<span class="k">return</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">(</span> <span class="nx">name</span><span class="p">,</span> <span class="k">this</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="p">);</span></div><div class='line' id='LC92'>		<span class="p">},</span></div><div class='line' id='LC93'><br/></div><div class='line' id='LC94'>		<span class="nx">domManip</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">args</span><span class="p">,</span> <span class="nx">table</span><span class="p">,</span> <span class="nx">callback</span><span class="p">,</span> <span class="nx">options</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC95'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">args</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="o">&amp;&amp;</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">isArray</span><span class="p">(</span> <span class="nx">args</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC96'>				<span class="kd">var</span> <span class="nx">dmArgs</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">makeArray</span><span class="p">(</span> <span class="nx">arguments</span> <span class="p">),</span> <span class="nx">elems</span> <span class="o">=</span> <span class="nx">args</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="nx">elemsLength</span> <span class="o">=</span> <span class="nx">elems</span><span class="p">.</span><span class="nx">length</span><span class="p">,</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">tmplItem</span><span class="p">;</span></div><div class='line' id='LC97'>				<span class="k">while</span> <span class="p">(</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">elemsLength</span> <span class="o">&amp;&amp;</span> <span class="o">!</span><span class="p">(</span><span class="nx">tmplItem</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span> <span class="nx">elems</span><span class="p">[</span><span class="nx">i</span><span class="o">++</span><span class="p">],</span> <span class="s2">&quot;tmplItem&quot;</span> <span class="p">)))</span> <span class="p">{}</span></div><div class='line' id='LC98'>				<span class="k">if</span> <span class="p">(</span> <span class="nx">tmplItem</span> <span class="o">&amp;&amp;</span> <span class="nx">cloneIndex</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC99'>					<span class="nx">dmArgs</span><span class="p">[</span><span class="mi">2</span><span class="p">]</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">fragClone</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC100'>						<span class="c1">// Handler called by oldManip when rendered template has been inserted into DOM.</span></div><div class='line' id='LC101'>						<span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">.</span><span class="nx">afterManip</span><span class="p">(</span> <span class="k">this</span><span class="p">,</span> <span class="nx">fragClone</span><span class="p">,</span> <span class="nx">callback</span> <span class="p">);</span></div><div class='line' id='LC102'>					<span class="p">};</span></div><div class='line' id='LC103'>				<span class="p">}</span></div><div class='line' id='LC104'>				<span class="nx">oldManip</span><span class="p">.</span><span class="nx">apply</span><span class="p">(</span> <span class="k">this</span><span class="p">,</span> <span class="nx">dmArgs</span> <span class="p">);</span></div><div class='line' id='LC105'>			<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC106'>				<span class="nx">oldManip</span><span class="p">.</span><span class="nx">apply</span><span class="p">(</span> <span class="k">this</span><span class="p">,</span> <span class="nx">arguments</span> <span class="p">);</span></div><div class='line' id='LC107'>			<span class="p">}</span></div><div class='line' id='LC108'>			<span class="nx">cloneIndex</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span></div><div class='line' id='LC109'>			<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">appendToTmplItems</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC110'>				<span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">.</span><span class="nx">complete</span><span class="p">(</span> <span class="nx">newTmplItems</span> <span class="p">);</span></div><div class='line' id='LC111'>			<span class="p">}</span></div><div class='line' id='LC112'>			<span class="k">return</span> <span class="k">this</span><span class="p">;</span></div><div class='line' id='LC113'>		<span class="p">}</span></div><div class='line' id='LC114'>	<span class="p">});</span></div><div class='line' id='LC115'><br/></div><div class='line' id='LC116'>	<span class="nx">jQuery</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC117'>		<span class="c1">// Return wrapped set of template items, obtained by rendering template against data.</span></div><div class='line' id='LC118'>		<span class="nx">tmpl</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="nx">data</span><span class="p">,</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">parentItem</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC119'>			<span class="kd">var</span> <span class="nx">ret</span><span class="p">,</span> <span class="nx">topLevel</span> <span class="o">=</span> <span class="o">!</span><span class="nx">parentItem</span><span class="p">;</span></div><div class='line' id='LC120'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">topLevel</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC121'>				<span class="c1">// This is a top-level tmpl call (not from a nested template using {{tmpl}})</span></div><div class='line' id='LC122'>				<span class="nx">parentItem</span> <span class="o">=</span> <span class="nx">topTmplItem</span><span class="p">;</span></div><div class='line' id='LC123'>				<span class="nx">tmpl</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">[</span><span class="nx">tmpl</span><span class="p">]</span> <span class="o">||</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">(</span> <span class="kc">null</span><span class="p">,</span> <span class="nx">tmpl</span> <span class="p">);</span></div><div class='line' id='LC124'>				<span class="nx">wrappedItems</span> <span class="o">=</span> <span class="p">{};</span> <span class="c1">// Any wrapped items will be rebuilt, since this is top level</span></div><div class='line' id='LC125'>			<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">tmpl</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC126'>				<span class="c1">// The template item is already associated with DOM - this is a refresh.</span></div><div class='line' id='LC127'>				<span class="c1">// Re-evaluate rendered template for the parentItem</span></div><div class='line' id='LC128'>				<span class="nx">tmpl</span> <span class="o">=</span> <span class="nx">parentItem</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">;</span></div><div class='line' id='LC129'>				<span class="nx">newTmplItems</span><span class="p">[</span><span class="nx">parentItem</span><span class="p">.</span><span class="nx">key</span><span class="p">]</span> <span class="o">=</span> <span class="nx">parentItem</span><span class="p">;</span></div><div class='line' id='LC130'>				<span class="nx">parentItem</span><span class="p">.</span><span class="nx">nodes</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC131'>				<span class="k">if</span> <span class="p">(</span> <span class="nx">parentItem</span><span class="p">.</span><span class="nx">wrapped</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC132'>					<span class="nx">updateWrapped</span><span class="p">(</span> <span class="nx">parentItem</span><span class="p">,</span> <span class="nx">parentItem</span><span class="p">.</span><span class="nx">wrapped</span> <span class="p">);</span></div><div class='line' id='LC133'>				<span class="p">}</span></div><div class='line' id='LC134'>				<span class="c1">// Rebuild, without creating a new template item</span></div><div class='line' id='LC135'>				<span class="k">return</span> <span class="nx">jQuery</span><span class="p">(</span> <span class="nx">build</span><span class="p">(</span> <span class="nx">parentItem</span><span class="p">,</span> <span class="kc">null</span><span class="p">,</span> <span class="nx">parentItem</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">(</span> <span class="nx">jQuery</span><span class="p">,</span> <span class="nx">parentItem</span> <span class="p">)</span> <span class="p">));</span></div><div class='line' id='LC136'>			<span class="p">}</span></div><div class='line' id='LC137'>			<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">tmpl</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC138'>				<span class="k">return</span> <span class="p">[];</span> <span class="c1">// Could throw...</span></div><div class='line' id='LC139'>			<span class="p">}</span></div><div class='line' id='LC140'>			<span class="k">if</span> <span class="p">(</span> <span class="k">typeof</span> <span class="nx">data</span> <span class="o">===</span> <span class="s2">&quot;function&quot;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC141'>				<span class="nx">data</span> <span class="o">=</span> <span class="nx">data</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span> <span class="nx">parentItem</span> <span class="o">||</span> <span class="p">{}</span> <span class="p">);</span></div><div class='line' id='LC142'>			<span class="p">}</span></div><div class='line' id='LC143'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">options</span> <span class="o">&amp;&amp;</span> <span class="nx">options</span><span class="p">.</span><span class="nx">wrapped</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC144'>				<span class="nx">updateWrapped</span><span class="p">(</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">options</span><span class="p">.</span><span class="nx">wrapped</span> <span class="p">);</span></div><div class='line' id='LC145'>			<span class="p">}</span></div><div class='line' id='LC146'>			<span class="nx">ret</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">isArray</span><span class="p">(</span> <span class="nx">data</span> <span class="p">)</span> <span class="o">?</span></div><div class='line' id='LC147'>				<span class="nx">jQuery</span><span class="p">.</span><span class="nx">map</span><span class="p">(</span> <span class="nx">data</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">dataItem</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC148'>					<span class="k">return</span> <span class="nx">dataItem</span> <span class="o">?</span> <span class="nx">newTmplItem</span><span class="p">(</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">parentItem</span><span class="p">,</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="nx">dataItem</span> <span class="p">)</span> <span class="o">:</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC149'>				<span class="p">})</span> <span class="o">:</span></div><div class='line' id='LC150'>				<span class="p">[</span> <span class="nx">newTmplItem</span><span class="p">(</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">parentItem</span><span class="p">,</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="nx">data</span> <span class="p">)</span> <span class="p">];</span></div><div class='line' id='LC151'>			<span class="k">return</span> <span class="nx">topLevel</span> <span class="o">?</span> <span class="nx">jQuery</span><span class="p">(</span> <span class="nx">build</span><span class="p">(</span> <span class="nx">parentItem</span><span class="p">,</span> <span class="kc">null</span><span class="p">,</span> <span class="nx">ret</span> <span class="p">)</span> <span class="p">)</span> <span class="o">:</span> <span class="nx">ret</span><span class="p">;</span></div><div class='line' id='LC152'>		<span class="p">},</span></div><div class='line' id='LC153'><br/></div><div class='line' id='LC154'>		<span class="c1">// Return rendered template item for an element.</span></div><div class='line' id='LC155'>		<span class="nx">tmplItem</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">elem</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC156'>			<span class="kd">var</span> <span class="nx">tmplItem</span><span class="p">;</span></div><div class='line' id='LC157'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">elem</span> <span class="k">instanceof</span> <span class="nx">jQuery</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC158'>				<span class="nx">elem</span> <span class="o">=</span> <span class="nx">elem</span><span class="p">[</span><span class="mi">0</span><span class="p">];</span></div><div class='line' id='LC159'>			<span class="p">}</span></div><div class='line' id='LC160'>			<span class="k">while</span> <span class="p">(</span> <span class="nx">elem</span> <span class="o">&amp;&amp;</span> <span class="nx">elem</span><span class="p">.</span><span class="nx">nodeType</span> <span class="o">===</span> <span class="mi">1</span> <span class="o">&amp;&amp;</span> <span class="o">!</span><span class="p">(</span><span class="nx">tmplItem</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span> <span class="nx">elem</span><span class="p">,</span> <span class="s2">&quot;tmplItem&quot;</span> <span class="p">))</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="nx">elem</span> <span class="o">=</span> <span class="nx">elem</span><span class="p">.</span><span class="nx">parentNode</span><span class="p">)</span> <span class="p">)</span> <span class="p">{}</span></div><div class='line' id='LC161'>			<span class="k">return</span> <span class="nx">tmplItem</span> <span class="o">||</span> <span class="nx">topTmplItem</span><span class="p">;</span></div><div class='line' id='LC162'>		<span class="p">},</span></div><div class='line' id='LC163'><br/></div><div class='line' id='LC164'>		<span class="c1">// Set:</span></div><div class='line' id='LC165'>		<span class="c1">// Use $.template( name, tmpl ) to cache a named template,</span></div><div class='line' id='LC166'>		<span class="c1">// where tmpl is a template string, a script element or a jQuery instance wrapping a script element, etc.</span></div><div class='line' id='LC167'>		<span class="c1">// Use $( &quot;selector&quot; ).template( name ) to provide access by name to a script block template declaration.</span></div><div class='line' id='LC168'><br/></div><div class='line' id='LC169'>		<span class="c1">// Get:</span></div><div class='line' id='LC170'>		<span class="c1">// Use $.template( name ) to access a cached template.</span></div><div class='line' id='LC171'>		<span class="c1">// Also $( selectorToScriptBlock ).template(), or $.template( null, templateString )</span></div><div class='line' id='LC172'>		<span class="c1">// will return the compiled template, without adding a name reference.</span></div><div class='line' id='LC173'>		<span class="c1">// If templateString includes at least one HTML tag, $.template( templateString ) is equivalent</span></div><div class='line' id='LC174'>		<span class="c1">// to $.template( null, templateString )</span></div><div class='line' id='LC175'>		<span class="nx">template</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">name</span><span class="p">,</span> <span class="nx">tmpl</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC176'>			<span class="k">if</span> <span class="p">(</span><span class="nx">tmpl</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC177'>				<span class="c1">// Compile template and associate with name</span></div><div class='line' id='LC178'>				<span class="k">if</span> <span class="p">(</span> <span class="k">typeof</span> <span class="nx">tmpl</span> <span class="o">===</span> <span class="s2">&quot;string&quot;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC179'>					<span class="c1">// This is an HTML string being passed directly in.</span></div><div class='line' id='LC180'>					<span class="nx">tmpl</span> <span class="o">=</span> <span class="nx">buildTmplFn</span><span class="p">(</span> <span class="nx">tmpl</span> <span class="p">);</span></div><div class='line' id='LC181'>				<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="nx">tmpl</span> <span class="k">instanceof</span> <span class="nx">jQuery</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC182'>					<span class="nx">tmpl</span> <span class="o">=</span> <span class="nx">tmpl</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="o">||</span> <span class="p">{};</span></div><div class='line' id='LC183'>				<span class="p">}</span></div><div class='line' id='LC184'>				<span class="k">if</span> <span class="p">(</span> <span class="nx">tmpl</span><span class="p">.</span><span class="nx">nodeType</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC185'>					<span class="c1">// If this is a template block, use cached copy, or generate tmpl function and cache.</span></div><div class='line' id='LC186'>					<span class="nx">tmpl</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="s2">&quot;tmpl&quot;</span> <span class="p">)</span> <span class="o">||</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="s2">&quot;tmpl&quot;</span><span class="p">,</span> <span class="nx">buildTmplFn</span><span class="p">(</span> <span class="nx">tmpl</span><span class="p">.</span><span class="nx">innerHTML</span> <span class="p">));</span></div><div class='line' id='LC187'>					<span class="c1">// Issue: In IE, if the container element is not a script block, the innerHTML will remove quotes from attribute values whenever the value does not include white space.</span></div><div class='line' id='LC188'>					<span class="c1">// This means that foo=&quot;${x}&quot; will not work if the value of x includes white space: foo=&quot;${x}&quot; -&gt; foo=value of x.</span></div><div class='line' id='LC189'>					<span class="c1">// To correct this, include space in tag: foo=&quot;${ x }&quot; -&gt; foo=&quot;value of x&quot;</span></div><div class='line' id='LC190'>				<span class="p">}</span></div><div class='line' id='LC191'>				<span class="k">return</span> <span class="k">typeof</span> <span class="nx">name</span> <span class="o">===</span> <span class="s2">&quot;string&quot;</span> <span class="o">?</span> <span class="p">(</span><span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">[</span><span class="nx">name</span><span class="p">]</span> <span class="o">=</span> <span class="nx">tmpl</span><span class="p">)</span> <span class="o">:</span> <span class="nx">tmpl</span><span class="p">;</span></div><div class='line' id='LC192'>			<span class="p">}</span></div><div class='line' id='LC193'>			<span class="c1">// Return named compiled template</span></div><div class='line' id='LC194'>			<span class="k">return</span> <span class="nx">name</span> <span class="o">?</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">name</span> <span class="o">!==</span> <span class="s2">&quot;string&quot;</span> <span class="o">?</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">(</span> <span class="kc">null</span><span class="p">,</span> <span class="nx">name</span> <span class="p">)</span><span class="o">:</span></div><div class='line' id='LC195'>				<span class="p">(</span><span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">[</span><span class="nx">name</span><span class="p">]</span> <span class="o">||</span></div><div class='line' id='LC196'>					<span class="c1">// If not in map, and not containing at least on HTML tag, treat as a selector.</span></div><div class='line' id='LC197'>					<span class="c1">// (If integrated with core, use quickExpr.exec)</span></div><div class='line' id='LC198'>					<span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">(</span> <span class="kc">null</span><span class="p">,</span> <span class="nx">htmlExpr</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span> <span class="nx">name</span> <span class="p">)</span> <span class="o">?</span> <span class="nx">name</span> <span class="o">:</span> <span class="nx">jQuery</span><span class="p">(</span> <span class="nx">name</span> <span class="p">))))</span> <span class="o">:</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC199'>		<span class="p">},</span></div><div class='line' id='LC200'><br/></div><div class='line' id='LC201'>		<span class="nx">encode</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">text</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC202'>			<span class="c1">// Do HTML encoding replacing &lt; &gt; &amp; and &#39; and &quot; by corresponding entities.</span></div><div class='line' id='LC203'>			<span class="k">return</span> <span class="p">(</span><span class="s2">&quot;&quot;</span> <span class="o">+</span> <span class="nx">text</span><span class="p">).</span><span class="nx">split</span><span class="p">(</span><span class="s2">&quot;&lt;&quot;</span><span class="p">).</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;&amp;lt;&quot;</span><span class="p">).</span><span class="nx">split</span><span class="p">(</span><span class="s2">&quot;&gt;&quot;</span><span class="p">).</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;&amp;gt;&quot;</span><span class="p">).</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39;&quot;&#39;</span><span class="p">).</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;&amp;#34;&quot;</span><span class="p">).</span><span class="nx">split</span><span class="p">(</span><span class="s2">&quot;&#39;&quot;</span><span class="p">).</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;&amp;#39;&quot;</span><span class="p">);</span></div><div class='line' id='LC204'>		<span class="p">}</span></div><div class='line' id='LC205'>	<span class="p">});</span></div><div class='line' id='LC206'><br/></div><div class='line' id='LC207'>	<span class="nx">jQuery</span><span class="p">.</span><span class="nx">extend</span><span class="p">(</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">,</span> <span class="p">{</span></div><div class='line' id='LC208'>		<span class="nx">tag</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC209'>			<span class="s2">&quot;tmpl&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC210'>				<span class="nx">_default</span><span class="o">:</span> <span class="p">{</span> <span class="nx">$2</span><span class="o">:</span> <span class="s2">&quot;null&quot;</span> <span class="p">},</span></div><div class='line' id='LC211'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;if($notnull_1){__=__.concat($item.nest($1,$2));}&quot;</span></div><div class='line' id='LC212'>				<span class="c1">// tmpl target parameter can be of type function, so use $1, not $1a (so not auto detection of functions)</span></div><div class='line' id='LC213'>				<span class="c1">// This means that {{tmpl foo}} treats foo as a template (which IS a function).</span></div><div class='line' id='LC214'>				<span class="c1">// Explicit parens can be used if foo is a function that returns a template: {{tmpl foo()}}.</span></div><div class='line' id='LC215'>			<span class="p">},</span></div><div class='line' id='LC216'>			<span class="s2">&quot;wrap&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC217'>				<span class="nx">_default</span><span class="o">:</span> <span class="p">{</span> <span class="nx">$2</span><span class="o">:</span> <span class="s2">&quot;null&quot;</span> <span class="p">},</span></div><div class='line' id='LC218'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;$item.calls(__,$1,$2);__=[];&quot;</span><span class="p">,</span></div><div class='line' id='LC219'>				<span class="nx">close</span><span class="o">:</span> <span class="s2">&quot;call=$item.calls();__=call._.concat($item.wrap(call,__));&quot;</span></div><div class='line' id='LC220'>			<span class="p">},</span></div><div class='line' id='LC221'>			<span class="s2">&quot;each&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC222'>				<span class="nx">_default</span><span class="o">:</span> <span class="p">{</span> <span class="nx">$2</span><span class="o">:</span> <span class="s2">&quot;$index, $value&quot;</span> <span class="p">},</span></div><div class='line' id='LC223'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;if($notnull_1){$.each($1a,function($2){with(this){&quot;</span><span class="p">,</span></div><div class='line' id='LC224'>				<span class="nx">close</span><span class="o">:</span> <span class="s2">&quot;}});}&quot;</span></div><div class='line' id='LC225'>			<span class="p">},</span></div><div class='line' id='LC226'>			<span class="s2">&quot;if&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC227'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;if(($notnull_1) &amp;&amp; $1a){&quot;</span><span class="p">,</span></div><div class='line' id='LC228'>				<span class="nx">close</span><span class="o">:</span> <span class="s2">&quot;}&quot;</span></div><div class='line' id='LC229'>			<span class="p">},</span></div><div class='line' id='LC230'>			<span class="s2">&quot;else&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC231'>				<span class="nx">_default</span><span class="o">:</span> <span class="p">{</span> <span class="nx">$1</span><span class="o">:</span> <span class="s2">&quot;true&quot;</span> <span class="p">},</span></div><div class='line' id='LC232'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;}else if(($notnull_1) &amp;&amp; $1a){&quot;</span></div><div class='line' id='LC233'>			<span class="p">},</span></div><div class='line' id='LC234'>			<span class="s2">&quot;html&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC235'>				<span class="c1">// Unecoded expression evaluation.</span></div><div class='line' id='LC236'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;if($notnull_1){__.push($1a);}&quot;</span></div><div class='line' id='LC237'>			<span class="p">},</span></div><div class='line' id='LC238'>			<span class="s2">&quot;=&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC239'>				<span class="c1">// Encoded expression evaluation. Abbreviated form is ${}.</span></div><div class='line' id='LC240'>				<span class="nx">_default</span><span class="o">:</span> <span class="p">{</span> <span class="nx">$1</span><span class="o">:</span> <span class="s2">&quot;$data&quot;</span> <span class="p">},</span></div><div class='line' id='LC241'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;if($notnull_1){__.push($.encode($1a));}&quot;</span></div><div class='line' id='LC242'>			<span class="p">},</span></div><div class='line' id='LC243'>			<span class="s2">&quot;!&quot;</span><span class="o">:</span> <span class="p">{</span></div><div class='line' id='LC244'>				<span class="c1">// Comment tag. Skipped by parser</span></div><div class='line' id='LC245'>				<span class="nx">open</span><span class="o">:</span> <span class="s2">&quot;&quot;</span></div><div class='line' id='LC246'>			<span class="p">}</span></div><div class='line' id='LC247'>		<span class="p">},</span></div><div class='line' id='LC248'><br/></div><div class='line' id='LC249'>		<span class="c1">// This stub can be overridden, e.g. in jquery.tmplPlus for providing rendered events</span></div><div class='line' id='LC250'>		<span class="nx">complete</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">items</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC251'>			<span class="nx">newTmplItems</span> <span class="o">=</span> <span class="p">{};</span></div><div class='line' id='LC252'>		<span class="p">},</span></div><div class='line' id='LC253'><br/></div><div class='line' id='LC254'>		<span class="c1">// Call this from code which overrides domManip, or equivalent</span></div><div class='line' id='LC255'>		<span class="c1">// Manage cloning/storing template items etc.</span></div><div class='line' id='LC256'>		<span class="nx">afterManip</span><span class="o">:</span> <span class="kd">function</span> <span class="nx">afterManip</span><span class="p">(</span> <span class="nx">elem</span><span class="p">,</span> <span class="nx">fragClone</span><span class="p">,</span> <span class="nx">callback</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC257'>			<span class="c1">// Provides cloned fragment ready for fixup prior to and after insertion into DOM</span></div><div class='line' id='LC258'>			<span class="kd">var</span> <span class="nx">content</span> <span class="o">=</span> <span class="nx">fragClone</span><span class="p">.</span><span class="nx">nodeType</span> <span class="o">===</span> <span class="mi">11</span> <span class="o">?</span></div><div class='line' id='LC259'>				<span class="nx">jQuery</span><span class="p">.</span><span class="nx">makeArray</span><span class="p">(</span><span class="nx">fragClone</span><span class="p">.</span><span class="nx">childNodes</span><span class="p">)</span> <span class="o">:</span></div><div class='line' id='LC260'>				<span class="nx">fragClone</span><span class="p">.</span><span class="nx">nodeType</span> <span class="o">===</span> <span class="mi">1</span> <span class="o">?</span> <span class="p">[</span><span class="nx">fragClone</span><span class="p">]</span> <span class="o">:</span> <span class="p">[];</span></div><div class='line' id='LC261'><br/></div><div class='line' id='LC262'>			<span class="c1">// Return fragment to original caller (e.g. append) for DOM insertion</span></div><div class='line' id='LC263'>			<span class="nx">callback</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span> <span class="nx">elem</span><span class="p">,</span> <span class="nx">fragClone</span> <span class="p">);</span></div><div class='line' id='LC264'><br/></div><div class='line' id='LC265'>			<span class="c1">// Fragment has been inserted:- Add inserted nodes to tmplItem data structure. Replace inserted element annotations by jQuery.data.</span></div><div class='line' id='LC266'>			<span class="nx">storeTmplItems</span><span class="p">(</span> <span class="nx">content</span> <span class="p">);</span></div><div class='line' id='LC267'>			<span class="nx">cloneIndex</span><span class="o">++</span><span class="p">;</span></div><div class='line' id='LC268'>		<span class="p">}</span></div><div class='line' id='LC269'>	<span class="p">});</span></div><div class='line' id='LC270'><br/></div><div class='line' id='LC271'>	<span class="c1">//========================== Private helper functions, used by code above ==========================</span></div><div class='line' id='LC272'><br/></div><div class='line' id='LC273'>	<span class="kd">function</span> <span class="nx">build</span><span class="p">(</span> <span class="nx">tmplItem</span><span class="p">,</span> <span class="nx">nested</span><span class="p">,</span> <span class="nx">content</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC274'>		<span class="c1">// Convert hierarchical content into flat string array</span></div><div class='line' id='LC275'>		<span class="c1">// and finally return array of fragments ready for DOM insertion</span></div><div class='line' id='LC276'>		<span class="kd">var</span> <span class="nx">frag</span><span class="p">,</span> <span class="nx">ret</span> <span class="o">=</span> <span class="nx">content</span> <span class="o">?</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">map</span><span class="p">(</span> <span class="nx">content</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">item</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC277'>			<span class="k">return</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">item</span> <span class="o">===</span> <span class="s2">&quot;string&quot;</span><span class="p">)</span> <span class="o">?</span></div><div class='line' id='LC278'>				<span class="c1">// Insert template item annotations, to be converted to jQuery.data( &quot;tmplItem&quot; ) when elems are inserted into DOM.</span></div><div class='line' id='LC279'>				<span class="p">(</span><span class="nx">tmplItem</span><span class="p">.</span><span class="nx">key</span> <span class="o">?</span> <span class="nx">item</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span> <span class="sr">/(&lt;\w+)(?=[\s&gt;])(?![^&gt;]*_tmplitem)([^&gt;]*)/g</span><span class="p">,</span> <span class="s2">&quot;$1 &quot;</span> <span class="o">+</span> <span class="nx">tmplItmAtt</span> <span class="o">+</span> <span class="s2">&quot;=\&quot;&quot;</span> <span class="o">+</span> <span class="nx">tmplItem</span><span class="p">.</span><span class="nx">key</span> <span class="o">+</span> <span class="s2">&quot;\&quot; $2&quot;</span> <span class="p">)</span> <span class="o">:</span> <span class="nx">item</span><span class="p">)</span> <span class="o">:</span></div><div class='line' id='LC280'>				<span class="c1">// This is a child template item. Build nested template.</span></div><div class='line' id='LC281'>				<span class="nx">build</span><span class="p">(</span> <span class="nx">item</span><span class="p">,</span> <span class="nx">tmplItem</span><span class="p">,</span> <span class="nx">item</span><span class="p">.</span><span class="nx">_ctnt</span> <span class="p">);</span></div><div class='line' id='LC282'>		<span class="p">})</span> <span class="o">:</span></div><div class='line' id='LC283'>		<span class="c1">// If content is not defined, insert tmplItem directly. Not a template item. May be a string, or a string array, e.g. from {{html $item.html()}}.</span></div><div class='line' id='LC284'>		<span class="nx">tmplItem</span><span class="p">;</span></div><div class='line' id='LC285'>		<span class="k">if</span> <span class="p">(</span> <span class="nx">nested</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC286'>			<span class="k">return</span> <span class="nx">ret</span><span class="p">;</span></div><div class='line' id='LC287'>		<span class="p">}</span></div><div class='line' id='LC288'><br/></div><div class='line' id='LC289'>		<span class="c1">// top-level template</span></div><div class='line' id='LC290'>		<span class="nx">ret</span> <span class="o">=</span> <span class="nx">ret</span><span class="p">.</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;&quot;</span><span class="p">);</span></div><div class='line' id='LC291'><br/></div><div class='line' id='LC292'>		<span class="c1">// Support templates which have initial or final text nodes, or consist only of text</span></div><div class='line' id='LC293'>		<span class="c1">// Also support HTML entities within the HTML markup.</span></div><div class='line' id='LC294'>		<span class="nx">ret</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span> <span class="sr">/^\s*([^&lt;\s][^&lt;]*)?(&lt;[\w\W]+&gt;)([^&gt;]*[^&gt;\s])?\s*$/</span><span class="p">,</span> <span class="kd">function</span><span class="p">(</span> <span class="nx">all</span><span class="p">,</span> <span class="nx">before</span><span class="p">,</span> <span class="nx">middle</span><span class="p">,</span> <span class="nx">after</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC295'>			<span class="nx">frag</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">(</span> <span class="nx">middle</span> <span class="p">).</span><span class="nx">get</span><span class="p">();</span></div><div class='line' id='LC296'><br/></div><div class='line' id='LC297'>			<span class="nx">storeTmplItems</span><span class="p">(</span> <span class="nx">frag</span> <span class="p">);</span></div><div class='line' id='LC298'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">before</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC299'>				<span class="nx">frag</span> <span class="o">=</span> <span class="nx">unencode</span><span class="p">(</span> <span class="nx">before</span> <span class="p">).</span><span class="nx">concat</span><span class="p">(</span><span class="nx">frag</span><span class="p">);</span></div><div class='line' id='LC300'>			<span class="p">}</span></div><div class='line' id='LC301'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">after</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC302'>				<span class="nx">frag</span> <span class="o">=</span> <span class="nx">frag</span><span class="p">.</span><span class="nx">concat</span><span class="p">(</span><span class="nx">unencode</span><span class="p">(</span> <span class="nx">after</span> <span class="p">));</span></div><div class='line' id='LC303'>			<span class="p">}</span></div><div class='line' id='LC304'>		<span class="p">});</span></div><div class='line' id='LC305'>		<span class="k">return</span> <span class="nx">frag</span> <span class="o">?</span> <span class="nx">frag</span> <span class="o">:</span> <span class="nx">unencode</span><span class="p">(</span> <span class="nx">ret</span> <span class="p">);</span></div><div class='line' id='LC306'>	<span class="p">}</span></div><div class='line' id='LC307'><br/></div><div class='line' id='LC308'>	<span class="kd">function</span> <span class="nx">unencode</span><span class="p">(</span> <span class="nx">text</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC309'>		<span class="c1">// Use createElement, since createTextNode will not render HTML entities correctly</span></div><div class='line' id='LC310'>		<span class="kd">var</span> <span class="nx">el</span> <span class="o">=</span> <span class="nb">document</span><span class="p">.</span><span class="nx">createElement</span><span class="p">(</span> <span class="s2">&quot;div&quot;</span> <span class="p">);</span></div><div class='line' id='LC311'>		<span class="nx">el</span><span class="p">.</span><span class="nx">innerHTML</span> <span class="o">=</span> <span class="nx">text</span><span class="p">;</span></div><div class='line' id='LC312'>		<span class="k">return</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">makeArray</span><span class="p">(</span><span class="nx">el</span><span class="p">.</span><span class="nx">childNodes</span><span class="p">);</span></div><div class='line' id='LC313'>	<span class="p">}</span></div><div class='line' id='LC314'><br/></div><div class='line' id='LC315'>	<span class="c1">// Generate a reusable function that will serve to render a template against data</span></div><div class='line' id='LC316'>	<span class="kd">function</span> <span class="nx">buildTmplFn</span><span class="p">(</span> <span class="nx">markup</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC317'>		<span class="k">return</span> <span class="k">new</span> <span class="nb">Function</span><span class="p">(</span><span class="s2">&quot;jQuery&quot;</span><span class="p">,</span><span class="s2">&quot;$item&quot;</span><span class="p">,</span></div><div class='line' id='LC318'>			<span class="c1">// Use the variable __ to hold a string array while building the compiled template. (See https://github.com/jquery/jquery-tmpl/issues#issue/10).</span></div><div class='line' id='LC319'>			<span class="s2">&quot;var $=jQuery,call,__=[],$data=$item.data;&quot;</span> <span class="o">+</span></div><div class='line' id='LC320'><br/></div><div class='line' id='LC321'>			<span class="c1">// Introduce the data as local variables using with(){}</span></div><div class='line' id='LC322'>			<span class="s2">&quot;with($data){__.push(&#39;&quot;</span> <span class="o">+</span></div><div class='line' id='LC323'><br/></div><div class='line' id='LC324'>			<span class="c1">// Convert the template into pure JavaScript</span></div><div class='line' id='LC325'>			<span class="nx">jQuery</span><span class="p">.</span><span class="nx">trim</span><span class="p">(</span><span class="nx">markup</span><span class="p">)</span></div><div class='line' id='LC326'>				<span class="p">.</span><span class="nx">replace</span><span class="p">(</span> <span class="sr">/([\\&#39;])/g</span><span class="p">,</span> <span class="s2">&quot;\\$1&quot;</span> <span class="p">)</span></div><div class='line' id='LC327'>				<span class="p">.</span><span class="nx">replace</span><span class="p">(</span> <span class="sr">/[\r\t\n]/g</span><span class="p">,</span> <span class="s2">&quot; &quot;</span> <span class="p">)</span></div><div class='line' id='LC328'>				<span class="p">.</span><span class="nx">replace</span><span class="p">(</span> <span class="sr">/\$\{([^\}]*)\}/g</span><span class="p">,</span> <span class="s2">&quot;{{= $1}}&quot;</span> <span class="p">)</span></div><div class='line' id='LC329'>				<span class="p">.</span><span class="nx">replace</span><span class="p">(</span> <span class="sr">/\{\{(\/?)(\w+|.)(?:\(((?:[^\}]|\}(?!\}))*?)?\))?(?:\s+(.*?)?)?(\(((?:[^\}]|\}(?!\}))*?)\))?\s*\}\}/g</span><span class="p">,</span></div><div class='line' id='LC330'>				<span class="kd">function</span><span class="p">(</span> <span class="nx">all</span><span class="p">,</span> <span class="nx">slash</span><span class="p">,</span> <span class="nx">type</span><span class="p">,</span> <span class="nx">fnargs</span><span class="p">,</span> <span class="nx">target</span><span class="p">,</span> <span class="nx">parens</span><span class="p">,</span> <span class="nx">args</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC331'>					<span class="kd">var</span> <span class="nx">tag</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">.</span><span class="nx">tag</span><span class="p">[</span> <span class="nx">type</span> <span class="p">],</span> <span class="nx">def</span><span class="p">,</span> <span class="nx">expr</span><span class="p">,</span> <span class="nx">exprAutoFnDetect</span><span class="p">;</span></div><div class='line' id='LC332'>					<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">tag</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC333'>						<span class="k">throw</span> <span class="s2">&quot;Unknown template tag: &quot;</span> <span class="o">+</span> <span class="nx">type</span><span class="p">;</span></div><div class='line' id='LC334'>					<span class="p">}</span></div><div class='line' id='LC335'>					<span class="nx">def</span> <span class="o">=</span> <span class="nx">tag</span><span class="p">.</span><span class="nx">_default</span> <span class="o">||</span> <span class="p">[];</span></div><div class='line' id='LC336'>					<span class="k">if</span> <span class="p">(</span> <span class="nx">parens</span> <span class="o">&amp;&amp;</span> <span class="o">!</span><span class="sr">/\w$/</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span><span class="nx">target</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC337'>						<span class="nx">target</span> <span class="o">+=</span> <span class="nx">parens</span><span class="p">;</span></div><div class='line' id='LC338'>						<span class="nx">parens</span> <span class="o">=</span> <span class="s2">&quot;&quot;</span><span class="p">;</span></div><div class='line' id='LC339'>					<span class="p">}</span></div><div class='line' id='LC340'>					<span class="k">if</span> <span class="p">(</span> <span class="nx">target</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC341'>						<span class="nx">target</span> <span class="o">=</span> <span class="nx">unescape</span><span class="p">(</span> <span class="nx">target</span> <span class="p">);</span></div><div class='line' id='LC342'>						<span class="nx">args</span> <span class="o">=</span> <span class="nx">args</span> <span class="o">?</span> <span class="p">(</span><span class="s2">&quot;,&quot;</span> <span class="o">+</span> <span class="nx">unescape</span><span class="p">(</span> <span class="nx">args</span> <span class="p">)</span> <span class="o">+</span> <span class="s2">&quot;)&quot;</span><span class="p">)</span> <span class="o">:</span> <span class="p">(</span><span class="nx">parens</span> <span class="o">?</span> <span class="s2">&quot;)&quot;</span> <span class="o">:</span> <span class="s2">&quot;&quot;</span><span class="p">);</span></div><div class='line' id='LC343'>						<span class="c1">// Support for target being things like a.toLowerCase();</span></div><div class='line' id='LC344'>						<span class="c1">// In that case don&#39;t call with template item as &#39;this&#39; pointer. Just evaluate...</span></div><div class='line' id='LC345'>						<span class="nx">expr</span> <span class="o">=</span> <span class="nx">parens</span> <span class="o">?</span> <span class="p">(</span><span class="nx">target</span><span class="p">.</span><span class="nx">indexOf</span><span class="p">(</span><span class="s2">&quot;.&quot;</span><span class="p">)</span> <span class="o">&gt;</span> <span class="o">-</span><span class="mi">1</span> <span class="o">?</span> <span class="nx">target</span> <span class="o">+</span> <span class="nx">unescape</span><span class="p">(</span> <span class="nx">parens</span> <span class="p">)</span> <span class="o">:</span> <span class="p">(</span><span class="s2">&quot;(&quot;</span> <span class="o">+</span> <span class="nx">target</span> <span class="o">+</span> <span class="s2">&quot;).call($item&quot;</span> <span class="o">+</span> <span class="nx">args</span><span class="p">))</span> <span class="o">:</span> <span class="nx">target</span><span class="p">;</span></div><div class='line' id='LC346'>						<span class="nx">exprAutoFnDetect</span> <span class="o">=</span> <span class="nx">parens</span> <span class="o">?</span> <span class="nx">expr</span> <span class="o">:</span> <span class="s2">&quot;(typeof(&quot;</span> <span class="o">+</span> <span class="nx">target</span> <span class="o">+</span> <span class="s2">&quot;)===&#39;function&#39;?(&quot;</span> <span class="o">+</span> <span class="nx">target</span> <span class="o">+</span> <span class="s2">&quot;).call($item):(&quot;</span> <span class="o">+</span> <span class="nx">target</span> <span class="o">+</span> <span class="s2">&quot;))&quot;</span><span class="p">;</span></div><div class='line' id='LC347'>					<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC348'>						<span class="nx">exprAutoFnDetect</span> <span class="o">=</span> <span class="nx">expr</span> <span class="o">=</span> <span class="nx">def</span><span class="p">.</span><span class="nx">$1</span> <span class="o">||</span> <span class="s2">&quot;null&quot;</span><span class="p">;</span></div><div class='line' id='LC349'>					<span class="p">}</span></div><div class='line' id='LC350'>					<span class="nx">fnargs</span> <span class="o">=</span> <span class="nx">unescape</span><span class="p">(</span> <span class="nx">fnargs</span> <span class="p">);</span></div><div class='line' id='LC351'>					<span class="k">return</span> <span class="s2">&quot;&#39;);&quot;</span> <span class="o">+</span></div><div class='line' id='LC352'>						<span class="nx">tag</span><span class="p">[</span> <span class="nx">slash</span> <span class="o">?</span> <span class="s2">&quot;close&quot;</span> <span class="o">:</span> <span class="s2">&quot;open&quot;</span> <span class="p">]</span></div><div class='line' id='LC353'>							<span class="p">.</span><span class="nx">split</span><span class="p">(</span> <span class="s2">&quot;$notnull_1&quot;</span> <span class="p">).</span><span class="nx">join</span><span class="p">(</span> <span class="nx">target</span> <span class="o">?</span> <span class="s2">&quot;typeof(&quot;</span> <span class="o">+</span> <span class="nx">target</span> <span class="o">+</span> <span class="s2">&quot;)!==&#39;undefined&#39; &amp;&amp; (&quot;</span> <span class="o">+</span> <span class="nx">target</span> <span class="o">+</span> <span class="s2">&quot;)!=null&quot;</span> <span class="o">:</span> <span class="s2">&quot;true&quot;</span> <span class="p">)</span></div><div class='line' id='LC354'>							<span class="p">.</span><span class="nx">split</span><span class="p">(</span> <span class="s2">&quot;$1a&quot;</span> <span class="p">).</span><span class="nx">join</span><span class="p">(</span> <span class="nx">exprAutoFnDetect</span> <span class="p">)</span></div><div class='line' id='LC355'>							<span class="p">.</span><span class="nx">split</span><span class="p">(</span> <span class="s2">&quot;$1&quot;</span> <span class="p">).</span><span class="nx">join</span><span class="p">(</span> <span class="nx">expr</span> <span class="p">)</span></div><div class='line' id='LC356'>							<span class="p">.</span><span class="nx">split</span><span class="p">(</span> <span class="s2">&quot;$2&quot;</span> <span class="p">).</span><span class="nx">join</span><span class="p">(</span> <span class="nx">fnargs</span> <span class="o">||</span> <span class="nx">def</span><span class="p">.</span><span class="nx">$2</span> <span class="o">||</span> <span class="s2">&quot;&quot;</span> <span class="p">)</span> <span class="o">+</span></div><div class='line' id='LC357'>						<span class="s2">&quot;__.push(&#39;&quot;</span><span class="p">;</span></div><div class='line' id='LC358'>				<span class="p">})</span> <span class="o">+</span></div><div class='line' id='LC359'>			<span class="s2">&quot;&#39;);}return __;&quot;</span></div><div class='line' id='LC360'>		<span class="p">);</span></div><div class='line' id='LC361'>	<span class="p">}</span></div><div class='line' id='LC362'>	<span class="kd">function</span> <span class="nx">updateWrapped</span><span class="p">(</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">wrapped</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC363'>		<span class="c1">// Build the wrapped content.</span></div><div class='line' id='LC364'>		<span class="nx">options</span><span class="p">.</span><span class="nx">_wrap</span> <span class="o">=</span> <span class="nx">build</span><span class="p">(</span> <span class="nx">options</span><span class="p">,</span> <span class="kc">true</span><span class="p">,</span></div><div class='line' id='LC365'>			<span class="c1">// Suport imperative scenario in which options.wrapped can be set to a selector or an HTML string.</span></div><div class='line' id='LC366'>			<span class="nx">jQuery</span><span class="p">.</span><span class="nx">isArray</span><span class="p">(</span> <span class="nx">wrapped</span> <span class="p">)</span> <span class="o">?</span> <span class="nx">wrapped</span> <span class="o">:</span> <span class="p">[</span><span class="nx">htmlExpr</span><span class="p">.</span><span class="nx">test</span><span class="p">(</span> <span class="nx">wrapped</span> <span class="p">)</span> <span class="o">?</span> <span class="nx">wrapped</span> <span class="o">:</span> <span class="nx">jQuery</span><span class="p">(</span> <span class="nx">wrapped</span> <span class="p">).</span><span class="nx">html</span><span class="p">()]</span></div><div class='line' id='LC367'>		<span class="p">).</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;&quot;</span><span class="p">);</span></div><div class='line' id='LC368'>	<span class="p">}</span></div><div class='line' id='LC369'><br/></div><div class='line' id='LC370'>	<span class="kd">function</span> <span class="nx">unescape</span><span class="p">(</span> <span class="nx">args</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC371'>		<span class="k">return</span> <span class="nx">args</span> <span class="o">?</span> <span class="nx">args</span><span class="p">.</span><span class="nx">replace</span><span class="p">(</span> <span class="sr">/\\&#39;/g</span><span class="p">,</span> <span class="s2">&quot;&#39;&quot;</span><span class="p">).</span><span class="nx">replace</span><span class="p">(</span><span class="sr">/\\\\/g</span><span class="p">,</span> <span class="s2">&quot;\\&quot;</span> <span class="p">)</span> <span class="o">:</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC372'>	<span class="p">}</span></div><div class='line' id='LC373'>	<span class="kd">function</span> <span class="nx">outerHtml</span><span class="p">(</span> <span class="nx">elem</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC374'>		<span class="kd">var</span> <span class="nx">div</span> <span class="o">=</span> <span class="nb">document</span><span class="p">.</span><span class="nx">createElement</span><span class="p">(</span><span class="s2">&quot;div&quot;</span><span class="p">);</span></div><div class='line' id='LC375'>		<span class="nx">div</span><span class="p">.</span><span class="nx">appendChild</span><span class="p">(</span> <span class="nx">elem</span><span class="p">.</span><span class="nx">cloneNode</span><span class="p">(</span><span class="kc">true</span><span class="p">)</span> <span class="p">);</span></div><div class='line' id='LC376'>		<span class="k">return</span> <span class="nx">div</span><span class="p">.</span><span class="nx">innerHTML</span><span class="p">;</span></div><div class='line' id='LC377'>	<span class="p">}</span></div><div class='line' id='LC378'><br/></div><div class='line' id='LC379'>	<span class="c1">// Store template items in jQuery.data(), ensuring a unique tmplItem data data structure for each rendered template instance.</span></div><div class='line' id='LC380'>	<span class="kd">function</span> <span class="nx">storeTmplItems</span><span class="p">(</span> <span class="nx">content</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC381'>		<span class="kd">var</span> <span class="nx">keySuffix</span> <span class="o">=</span> <span class="s2">&quot;_&quot;</span> <span class="o">+</span> <span class="nx">cloneIndex</span><span class="p">,</span> <span class="nx">elem</span><span class="p">,</span> <span class="nx">elems</span><span class="p">,</span> <span class="nx">newClonedItems</span> <span class="o">=</span> <span class="p">{},</span> <span class="nx">i</span><span class="p">,</span> <span class="nx">l</span><span class="p">,</span> <span class="nx">m</span><span class="p">;</span></div><div class='line' id='LC382'>		<span class="k">for</span> <span class="p">(</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">l</span> <span class="o">=</span> <span class="nx">content</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">l</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC383'>			<span class="k">if</span> <span class="p">(</span> <span class="p">(</span><span class="nx">elem</span> <span class="o">=</span> <span class="nx">content</span><span class="p">[</span><span class="nx">i</span><span class="p">]).</span><span class="nx">nodeType</span> <span class="o">!==</span> <span class="mi">1</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC384'>				<span class="k">continue</span><span class="p">;</span></div><div class='line' id='LC385'>			<span class="p">}</span></div><div class='line' id='LC386'>			<span class="nx">elems</span> <span class="o">=</span> <span class="nx">elem</span><span class="p">.</span><span class="nx">getElementsByTagName</span><span class="p">(</span><span class="s2">&quot;*&quot;</span><span class="p">);</span></div><div class='line' id='LC387'>			<span class="k">for</span> <span class="p">(</span> <span class="nx">m</span> <span class="o">=</span> <span class="nx">elems</span><span class="p">.</span><span class="nx">length</span> <span class="o">-</span> <span class="mi">1</span><span class="p">;</span> <span class="nx">m</span> <span class="o">&gt;=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">m</span><span class="o">--</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC388'>				<span class="nx">processItemKey</span><span class="p">(</span> <span class="nx">elems</span><span class="p">[</span><span class="nx">m</span><span class="p">]</span> <span class="p">);</span></div><div class='line' id='LC389'>			<span class="p">}</span></div><div class='line' id='LC390'>			<span class="nx">processItemKey</span><span class="p">(</span> <span class="nx">elem</span> <span class="p">);</span></div><div class='line' id='LC391'>		<span class="p">}</span></div><div class='line' id='LC392'>		<span class="kd">function</span> <span class="nx">processItemKey</span><span class="p">(</span> <span class="nx">el</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC393'>			<span class="kd">var</span> <span class="nx">pntKey</span><span class="p">,</span> <span class="nx">pntNode</span> <span class="o">=</span> <span class="nx">el</span><span class="p">,</span> <span class="nx">pntItem</span><span class="p">,</span> <span class="nx">tmplItem</span><span class="p">,</span> <span class="nx">key</span><span class="p">;</span></div><div class='line' id='LC394'>			<span class="c1">// Ensure that each rendered template inserted into the DOM has its own template item,</span></div><div class='line' id='LC395'>			<span class="k">if</span> <span class="p">(</span> <span class="p">(</span><span class="nx">key</span> <span class="o">=</span> <span class="nx">el</span><span class="p">.</span><span class="nx">getAttribute</span><span class="p">(</span> <span class="nx">tmplItmAtt</span> <span class="p">)))</span> <span class="p">{</span></div><div class='line' id='LC396'>				<span class="k">while</span> <span class="p">(</span> <span class="nx">pntNode</span><span class="p">.</span><span class="nx">parentNode</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="nx">pntNode</span> <span class="o">=</span> <span class="nx">pntNode</span><span class="p">.</span><span class="nx">parentNode</span><span class="p">).</span><span class="nx">nodeType</span> <span class="o">===</span> <span class="mi">1</span> <span class="o">&amp;&amp;</span> <span class="o">!</span><span class="p">(</span><span class="nx">pntKey</span> <span class="o">=</span> <span class="nx">pntNode</span><span class="p">.</span><span class="nx">getAttribute</span><span class="p">(</span> <span class="nx">tmplItmAtt</span> <span class="p">)))</span> <span class="p">{</span> <span class="p">}</span></div><div class='line' id='LC397'>				<span class="k">if</span> <span class="p">(</span> <span class="nx">pntKey</span> <span class="o">!==</span> <span class="nx">key</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC398'>					<span class="c1">// The next ancestor with a _tmplitem expando is on a different key than this one.</span></div><div class='line' id='LC399'>					<span class="c1">// So this is a top-level element within this template item</span></div><div class='line' id='LC400'>					<span class="c1">// Set pntNode to the key of the parentNode, or to 0 if pntNode.parentNode is null, or pntNode is a fragment.</span></div><div class='line' id='LC401'>					<span class="nx">pntNode</span> <span class="o">=</span> <span class="nx">pntNode</span><span class="p">.</span><span class="nx">parentNode</span> <span class="o">?</span> <span class="p">(</span><span class="nx">pntNode</span><span class="p">.</span><span class="nx">nodeType</span> <span class="o">===</span> <span class="mi">11</span> <span class="o">?</span> <span class="mi">0</span> <span class="o">:</span> <span class="p">(</span><span class="nx">pntNode</span><span class="p">.</span><span class="nx">getAttribute</span><span class="p">(</span> <span class="nx">tmplItmAtt</span> <span class="p">)</span> <span class="o">||</span> <span class="mi">0</span><span class="p">))</span> <span class="o">:</span> <span class="mi">0</span><span class="p">;</span></div><div class='line' id='LC402'>					<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="p">(</span><span class="nx">tmplItem</span> <span class="o">=</span> <span class="nx">newTmplItems</span><span class="p">[</span><span class="nx">key</span><span class="p">])</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC403'>						<span class="c1">// The item is for wrapped content, and was copied from the temporary parent wrappedItem.</span></div><div class='line' id='LC404'>						<span class="nx">tmplItem</span> <span class="o">=</span> <span class="nx">wrappedItems</span><span class="p">[</span><span class="nx">key</span><span class="p">];</span></div><div class='line' id='LC405'>						<span class="nx">tmplItem</span> <span class="o">=</span> <span class="nx">newTmplItem</span><span class="p">(</span> <span class="nx">tmplItem</span><span class="p">,</span> <span class="nx">newTmplItems</span><span class="p">[</span><span class="nx">pntNode</span><span class="p">]</span><span class="o">||</span><span class="nx">wrappedItems</span><span class="p">[</span><span class="nx">pntNode</span><span class="p">]</span> <span class="p">);</span></div><div class='line' id='LC406'>						<span class="nx">tmplItem</span><span class="p">.</span><span class="nx">key</span> <span class="o">=</span> <span class="o">++</span><span class="nx">itemKey</span><span class="p">;</span></div><div class='line' id='LC407'>						<span class="nx">newTmplItems</span><span class="p">[</span><span class="nx">itemKey</span><span class="p">]</span> <span class="o">=</span> <span class="nx">tmplItem</span><span class="p">;</span></div><div class='line' id='LC408'>					<span class="p">}</span></div><div class='line' id='LC409'>					<span class="k">if</span> <span class="p">(</span> <span class="nx">cloneIndex</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC410'>						<span class="nx">cloneTmplItem</span><span class="p">(</span> <span class="nx">key</span> <span class="p">);</span></div><div class='line' id='LC411'>					<span class="p">}</span></div><div class='line' id='LC412'>				<span class="p">}</span></div><div class='line' id='LC413'>				<span class="nx">el</span><span class="p">.</span><span class="nx">removeAttribute</span><span class="p">(</span> <span class="nx">tmplItmAtt</span> <span class="p">);</span></div><div class='line' id='LC414'>			<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="nx">cloneIndex</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="nx">tmplItem</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span> <span class="nx">el</span><span class="p">,</span> <span class="s2">&quot;tmplItem&quot;</span> <span class="p">))</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC415'>				<span class="c1">// This was a rendered element, cloned during append or appendTo etc.</span></div><div class='line' id='LC416'>				<span class="c1">// TmplItem stored in jQuery data has already been cloned in cloneCopyEvent. We must replace it with a fresh cloned tmplItem.</span></div><div class='line' id='LC417'>				<span class="nx">cloneTmplItem</span><span class="p">(</span> <span class="nx">tmplItem</span><span class="p">.</span><span class="nx">key</span> <span class="p">);</span></div><div class='line' id='LC418'>				<span class="nx">newTmplItems</span><span class="p">[</span><span class="nx">tmplItem</span><span class="p">.</span><span class="nx">key</span><span class="p">]</span> <span class="o">=</span> <span class="nx">tmplItem</span><span class="p">;</span></div><div class='line' id='LC419'>				<span class="nx">pntNode</span> <span class="o">=</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span> <span class="nx">el</span><span class="p">.</span><span class="nx">parentNode</span><span class="p">,</span> <span class="s2">&quot;tmplItem&quot;</span> <span class="p">);</span></div><div class='line' id='LC420'>				<span class="nx">pntNode</span> <span class="o">=</span> <span class="nx">pntNode</span> <span class="o">?</span> <span class="nx">pntNode</span><span class="p">.</span><span class="nx">key</span> <span class="o">:</span> <span class="mi">0</span><span class="p">;</span></div><div class='line' id='LC421'>			<span class="p">}</span></div><div class='line' id='LC422'>			<span class="k">if</span> <span class="p">(</span> <span class="nx">tmplItem</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC423'>				<span class="nx">pntItem</span> <span class="o">=</span> <span class="nx">tmplItem</span><span class="p">;</span></div><div class='line' id='LC424'>				<span class="c1">// Find the template item of the parent element.</span></div><div class='line' id='LC425'>				<span class="c1">// (Using !=, not !==, since pntItem.key is number, and pntNode may be a string)</span></div><div class='line' id='LC426'>				<span class="k">while</span> <span class="p">(</span> <span class="nx">pntItem</span> <span class="o">&amp;&amp;</span> <span class="nx">pntItem</span><span class="p">.</span><span class="nx">key</span> <span class="o">!=</span> <span class="nx">pntNode</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC427'>					<span class="c1">// Add this element as a top-level node for this rendered template item, as well as for any</span></div><div class='line' id='LC428'>					<span class="c1">// ancestor items between this item and the item of its parent element</span></div><div class='line' id='LC429'>					<span class="nx">pntItem</span><span class="p">.</span><span class="nx">nodes</span><span class="p">.</span><span class="nx">push</span><span class="p">(</span> <span class="nx">el</span> <span class="p">);</span></div><div class='line' id='LC430'>					<span class="nx">pntItem</span> <span class="o">=</span> <span class="nx">pntItem</span><span class="p">.</span><span class="nx">parent</span><span class="p">;</span></div><div class='line' id='LC431'>				<span class="p">}</span></div><div class='line' id='LC432'>				<span class="c1">// Delete content built during rendering - reduce API surface area and memory use, and avoid exposing of stale data after rendering...</span></div><div class='line' id='LC433'>				<span class="k">delete</span> <span class="nx">tmplItem</span><span class="p">.</span><span class="nx">_ctnt</span><span class="p">;</span></div><div class='line' id='LC434'>				<span class="k">delete</span> <span class="nx">tmplItem</span><span class="p">.</span><span class="nx">_wrap</span><span class="p">;</span></div><div class='line' id='LC435'>				<span class="c1">// Store template item as jQuery data on the element</span></div><div class='line' id='LC436'>				<span class="nx">jQuery</span><span class="p">.</span><span class="nx">data</span><span class="p">(</span> <span class="nx">el</span><span class="p">,</span> <span class="s2">&quot;tmplItem&quot;</span><span class="p">,</span> <span class="nx">tmplItem</span> <span class="p">);</span></div><div class='line' id='LC437'>			<span class="p">}</span></div><div class='line' id='LC438'>			<span class="kd">function</span> <span class="nx">cloneTmplItem</span><span class="p">(</span> <span class="nx">key</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC439'>				<span class="nx">key</span> <span class="o">=</span> <span class="nx">key</span> <span class="o">+</span> <span class="nx">keySuffix</span><span class="p">;</span></div><div class='line' id='LC440'>				<span class="nx">tmplItem</span> <span class="o">=</span> <span class="nx">newClonedItems</span><span class="p">[</span><span class="nx">key</span><span class="p">]</span> <span class="o">=</span></div><div class='line' id='LC441'>					<span class="p">(</span><span class="nx">newClonedItems</span><span class="p">[</span><span class="nx">key</span><span class="p">]</span> <span class="o">||</span> <span class="nx">newTmplItem</span><span class="p">(</span> <span class="nx">tmplItem</span><span class="p">,</span> <span class="nx">newTmplItems</span><span class="p">[</span><span class="nx">tmplItem</span><span class="p">.</span><span class="nx">parent</span><span class="p">.</span><span class="nx">key</span> <span class="o">+</span> <span class="nx">keySuffix</span><span class="p">]</span> <span class="o">||</span> <span class="nx">tmplItem</span><span class="p">.</span><span class="nx">parent</span> <span class="p">));</span></div><div class='line' id='LC442'>			<span class="p">}</span></div><div class='line' id='LC443'>		<span class="p">}</span></div><div class='line' id='LC444'>	<span class="p">}</span></div><div class='line' id='LC445'><br/></div><div class='line' id='LC446'>	<span class="c1">//---- Helper functions for template item ----</span></div><div class='line' id='LC447'><br/></div><div class='line' id='LC448'>	<span class="kd">function</span> <span class="nx">tiCalls</span><span class="p">(</span> <span class="nx">content</span><span class="p">,</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="nx">data</span><span class="p">,</span> <span class="nx">options</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC449'>		<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">content</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC450'>			<span class="k">return</span> <span class="nx">stack</span><span class="p">.</span><span class="nx">pop</span><span class="p">();</span></div><div class='line' id='LC451'>		<span class="p">}</span></div><div class='line' id='LC452'>		<span class="nx">stack</span><span class="p">.</span><span class="nx">push</span><span class="p">({</span> <span class="nx">_</span><span class="o">:</span> <span class="nx">content</span><span class="p">,</span> <span class="nx">tmpl</span><span class="o">:</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="nx">item</span><span class="o">:</span><span class="k">this</span><span class="p">,</span> <span class="nx">data</span><span class="o">:</span> <span class="nx">data</span><span class="p">,</span> <span class="nx">options</span><span class="o">:</span> <span class="nx">options</span> <span class="p">});</span></div><div class='line' id='LC453'>	<span class="p">}</span></div><div class='line' id='LC454'><br/></div><div class='line' id='LC455'>	<span class="kd">function</span> <span class="nx">tiNest</span><span class="p">(</span> <span class="nx">tmpl</span><span class="p">,</span> <span class="nx">data</span><span class="p">,</span> <span class="nx">options</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC456'>		<span class="c1">// nested template, using {{tmpl}} tag</span></div><div class='line' id='LC457'>		<span class="k">return</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">(</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">(</span> <span class="nx">tmpl</span> <span class="p">),</span> <span class="nx">data</span><span class="p">,</span> <span class="nx">options</span><span class="p">,</span> <span class="k">this</span> <span class="p">);</span></div><div class='line' id='LC458'>	<span class="p">}</span></div><div class='line' id='LC459'><br/></div><div class='line' id='LC460'>	<span class="kd">function</span> <span class="nx">tiWrap</span><span class="p">(</span> <span class="nx">call</span><span class="p">,</span> <span class="nx">wrapped</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC461'>		<span class="c1">// nested template, using {{wrap}} tag</span></div><div class='line' id='LC462'>		<span class="kd">var</span> <span class="nx">options</span> <span class="o">=</span> <span class="nx">call</span><span class="p">.</span><span class="nx">options</span> <span class="o">||</span> <span class="p">{};</span></div><div class='line' id='LC463'>		<span class="nx">options</span><span class="p">.</span><span class="nx">wrapped</span> <span class="o">=</span> <span class="nx">wrapped</span><span class="p">;</span></div><div class='line' id='LC464'>		<span class="c1">// Apply the template, which may incorporate wrapped content,</span></div><div class='line' id='LC465'>		<span class="k">return</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">(</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">template</span><span class="p">(</span> <span class="nx">call</span><span class="p">.</span><span class="nx">tmpl</span> <span class="p">),</span> <span class="nx">call</span><span class="p">.</span><span class="nx">data</span><span class="p">,</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">call</span><span class="p">.</span><span class="nx">item</span> <span class="p">);</span></div><div class='line' id='LC466'>	<span class="p">}</span></div><div class='line' id='LC467'><br/></div><div class='line' id='LC468'>	<span class="kd">function</span> <span class="nx">tiHtml</span><span class="p">(</span> <span class="nx">filter</span><span class="p">,</span> <span class="nx">textOnly</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC469'>		<span class="kd">var</span> <span class="nx">wrapped</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_wrap</span><span class="p">;</span></div><div class='line' id='LC470'>		<span class="k">return</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">map</span><span class="p">(</span></div><div class='line' id='LC471'>			<span class="nx">jQuery</span><span class="p">(</span> <span class="nx">jQuery</span><span class="p">.</span><span class="nx">isArray</span><span class="p">(</span> <span class="nx">wrapped</span> <span class="p">)</span> <span class="o">?</span> <span class="nx">wrapped</span><span class="p">.</span><span class="nx">join</span><span class="p">(</span><span class="s2">&quot;&quot;</span><span class="p">)</span> <span class="o">:</span> <span class="nx">wrapped</span> <span class="p">).</span><span class="nx">filter</span><span class="p">(</span> <span class="nx">filter</span> <span class="o">||</span> <span class="s2">&quot;*&quot;</span> <span class="p">),</span></div><div class='line' id='LC472'>			<span class="kd">function</span><span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC473'>				<span class="k">return</span> <span class="nx">textOnly</span> <span class="o">?</span></div><div class='line' id='LC474'>					<span class="nx">e</span><span class="p">.</span><span class="nx">innerText</span> <span class="o">||</span> <span class="nx">e</span><span class="p">.</span><span class="nx">textContent</span> <span class="o">:</span></div><div class='line' id='LC475'>					<span class="nx">e</span><span class="p">.</span><span class="nx">outerHTML</span> <span class="o">||</span> <span class="nx">outerHtml</span><span class="p">(</span><span class="nx">e</span><span class="p">);</span></div><div class='line' id='LC476'>			<span class="p">});</span></div><div class='line' id='LC477'>	<span class="p">}</span></div><div class='line' id='LC478'><br/></div><div class='line' id='LC479'>	<span class="kd">function</span> <span class="nx">tiUpdate</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC480'>		<span class="kd">var</span> <span class="nx">coll</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">nodes</span><span class="p">;</span></div><div class='line' id='LC481'>		<span class="nx">jQuery</span><span class="p">.</span><span class="nx">tmpl</span><span class="p">(</span> <span class="kc">null</span><span class="p">,</span> <span class="kc">null</span><span class="p">,</span> <span class="kc">null</span><span class="p">,</span> <span class="k">this</span><span class="p">).</span><span class="nx">insertBefore</span><span class="p">(</span> <span class="nx">coll</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="p">);</span></div><div class='line' id='LC482'>		<span class="nx">jQuery</span><span class="p">(</span> <span class="nx">coll</span> <span class="p">).</span><span class="nx">remove</span><span class="p">();</span></div><div class='line' id='LC483'>	<span class="p">}</span></div><div class='line' id='LC484'><span class="p">})(</span> <span class="nx">jQuery</span> <span class="p">);</span></div></pre></div></td>
          </tr>
        </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/">
      <span class="mega-octicon octicon-mark-github" title="GitHub"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2014 <span title="0.04532s from github-fe127-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="fullscreen-contents js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped tooltipped-w" aria-label="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped tooltipped-w"
      aria-label="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-remove-close close js-ajax-error-dismiss"></a>
      Something went wrong with that request. Please try again.
    </div>

  </body>
</html>

