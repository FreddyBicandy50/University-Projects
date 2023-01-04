<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home page</title>
    <!--CSS Style-->
    <link rel="stylesheet"
        href="http://localhost:3000/Webdev/University/Project/header.css">
    <link rel="stylesheet"
        href="http://localhost:3000/Webdev/University/Project/home.css">
    <link rel="stylesheet"
        href="http://localhost:3000/Webdev/University/Project/slider.css">
    <script src="http://localhost:3000/Webdev/University/Project/script.js"
        defer></script>
    <script src="http://localhost:3000/Webdev/University/Project/slider.js"
        defer></script>
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
</head>

<body>

    <div data-aos-delay="500" data-aos="fade-down" id="header">
        <div id="headinside">
            <div data-aos="fade-left"  class="dropdown" data-dropdown>
                <a id="contact" href="tel:+96179131124" Style="right: 10px;">Call Now+96179131124</a>
                <button class="dropdown_button" data-dropdown-button>
                    <b class="dropdown_button" data-dropdown-button>My Account ▼</b> </button>
                <div class="dropdown_menu">
                    <form method="post"
                        action="http://localhost:3000/Webdev/University/Project/site.php">
                        <div class="input-box">
                            <input class="user_pswd" type="email" name="email" placeholder=" " required />
                            <label>
                                <h5>Username</h5>
                            </label>
                        </div>
                        <div class="input-box">
                            <input class="user_pswd" type="password" name="paswd" placeholder=" " required />
                            <label>
                                <h5>Password</h5>
                            </label>
                        </div>
                        <input class="login_btn" type="submit" value="LOGIN" id="login" required />

                        <a
                            href="file://wsl.localhost/kali-linux/home/null/programing/Webdev/University/Files/thanks.html">
                            <font size=2><br><br>forgot password?</font>
                        </a>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div id="navbar"> 
        <a data-aos="fade-right"
            href="http://localhost:3000/Webdev/University/Project/Bicandy's%20Network%20Solutions.php">
            <img id="Logo"
                src="http://localhost:3000/Webdev/University/Project/logo.png"
                alt="logo"></img> </a>
        <div id="navinside">
            <a class="nav_btn"
                href="http://localhost:3000/Webdev/University/Project/shop.php">
                <h3 data-aos-delay="500" data-aos="fade-down" id="Shop">Shop</h3>
            </a>
            <a class="nav_btn"
                href="http://localhost:3000/Webdev/University/Project/Contact.php">
                <h3 data-aos-delay="500" data-aos="fade-down" id="Contact">Contact</h3>
            </a>
            <a class="nav_btn"
                href="http://localhost:3000/Webdev/University/Project/About.php">
                <h3 data-aos-delay="500" data-aos="fade-down"id="About">About</h3>
            </a>
            
        </div>
    </div> 
    <!-- Slideshow container -->
    <div class="slideshow-container">

        <!-- Full-width images with number and caption text -->
        <div class="mySlides">
            <img style="opacity: 0.8;"
                src="http://localhost:3000/Webdev/University/Project/imageslider1.jpg"
                alt="image slider 1">
            <h1>
                <marquee data-aos-delay="1500" data-aos="fade-up" scrollamount="20" behavior="slide" direction="up">Join
                    Bicandy Network Solutions today <br> for the
                    Best Quality Internet Experience</marquee>
            </h1>
        </div>

        <div class="mySlides" data-interval="1000">
            <img style="opacity: 0.6"
                src="http://localhost:3000/Webdev/University/Project/imageslider2.jpg"
                alt="image slider 2">
            <h1>
                <marquee>
                    NEW GAMING <br> DSL PLANS.
                </marquee>
            </h1>
        </div>

        <div class="mySlides">
            <img style="opacity: 0.6"
                src="http://localhost:3000/Webdev/University/Project/imageslider3.jpg"
                alt="image slider 3">
            <h1 style="margin-left: 5% !important"> 
                <marquee > 
                    Fiber Optics Connection that can reach speeds of <br>
                    up to 940 Megabits per second. 
                </marquee>
            </h1>
        </div>

        <!-- Next and previous buttons -->
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
    </div>
    <br>

    <!-- The dots/circles -->
    <div style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
    </div>

    <div id="theme1">
        <div   data-aos="fade-up" id="Corporate_box">
            <image src="http://localhost:3000/Webdev/University/Project/server.png"
                class="center_icon" alt="server  icon">
            </image>
            <h3 align="center">
                Corporate Service
            </h3>
            <br>
            <p align="center">
                <font size="3px" ;face="arial">Dedicated connectivity with high availability is <br> designed for all
                    business users.
            </p>
            </font>

        </div>
        <div   data-aos="fade-up" id="Residantal_box">
            <image src="http://localhost:3000/Webdev/University/Project/download.png"
                class="center_icon" alt="service icon"></image>
            <h3 align="center">
                Residential Service
            </h3>
            <br>
            <p align="center">
                <font size="3px" ;face="arial">Plans are available to meet every ones need. Check <br>our available
                    packages which includes<br>residential/gaming DSL.
            </p>
            </font>
        </div>
        <div   data-aos="fade-up" id="Fiber_box">
            <image src="http://localhost:3000/Webdev/University/Project/fiber.png"
                class="center_icon" alt="fiber icon"></image>
            <h3 align="center">
                Fiber
            </h3>
            <br>
            <p align="center">
                <font size="3px" ;face="arial">With BNS get ultrahigh speed internet <br>service. Contact us
                    to check availability in your area.
            </p>
            </font>
        </div>
        <div    data-aos="fade-up" id="support_box">
            <image src="http://localhost:3000/Webdev/University/Project/customer.png"
                class="center_icon" alt="customer support icon"></image>
            <h3 align="center">
                24/7 Customer Support
            </h3>
            <br>
            <p align="center">
                <font size="3px" ;face="arial">Dedicated team of professionals providing a round<br>-clock exceptional
                    client support.
                </font>
        </div>
        <div   data-aos="fade-up" id="Service_details_box">
            <h1 align="center">
                <font size="14" color="white">We are the no.1 Quality service <br> provider company in the Country
                </font>
            </h1>

            <p   data-aos="fade-up" align="center">
                <font size="4px" color="white">
                    <br>
                    Bicandy's Network Solutions  is dedicated in providing high quality services to professionals with <br> delicate
                    needs In the Business,
                    Gaming and Residential sectors. We do not only <br> focus on the mass coverage of the basic market
                    needs, we also integrate
                    our <br> services to meet higher standards of quality required by users with a more <br> specialized
                    need in their business
                    nature.The end result is an experience that <br> combines creativity, unique quality of service and
                    an exceptional after
                    sales<br> support.
                </font>
            </p>
        </div>
    </div>
    <div id="available_Sevices">
        <h1  data-aos="fade-up" style="position:absolute;color:white; margin-left:40%;margin-top:5%">Services We Provide
        </h1>
        <p data-aos="fade-up" style="position:absolute;color:white; margin-left:38%;margin-top:8%">Choose from below the service that best
            fits your needs</p>
        <image class="serviceimg_center"
            src="http://localhost:3000/Webdev/University/Project/services.png">
        </image>
    </div>
    <div data-aos="fade-up" id="plans_box">
        
        <image class="plansimage"
            src="http://localhost:3000/Webdev/University/Project/plans.png">
           <a style="text-decoration:none" href="http://localhost:3000/Webdev/University/Project/inquire.php"><div class="btn_position1">
            <p align="center"> Order This Plan </p>
        </div></a> 
           <a style="text-decoration:none" href="http://localhost:3000/Webdev/University/Project/inquire.php"><div class="btn_position2">
            <p align="center"> <font color="blue;">Order This Plan</font> </p>
        </div></a> 
           <a style="text-decoration:none" href="http://localhost:3000/Webdev/University/Project/inquire.php"><div class="btn_position3">
            <p align="center"> Order This Plan </p>
        </div></a> 
        </image>
    </div>

    <div id="white">
        <image data-aos="fade-up" class="includeimage"
            src="http://localhost:3000/Webdev/University/Project/include.png">
        </image>
    </div>
     
    <div class="back-to-top">
        <a href='#'> 
            <img  class="back-to-top"  
            src="http://localhost:3000/Webdev/University/Project/arrowup.png"> </a>
    </div> 

<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
<script>
    AOS.init({
        duration: 1000
    });
</script>
</body>


</html>