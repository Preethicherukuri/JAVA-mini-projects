package Assignments.PortfolioGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Desktop;

public class PortfolioBuilder {

    public void build(PortfolioData data, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            // Start of HTML
            bw.write("""
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>
                    """);

            // Insert name inside title
            bw.write(data.getName());

            bw.write("""
                        </title>
                        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
                        <style>
                            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');
                            
                            :root {
                                --primary: #667eea;
                                --secondary: #764ba2;
                                --accent: #f093fb;
                                --dark: #2d3748;
                                --light: #f7fafc;
                                --text: #4a5568;
                                --shadow: 0 20px 40px rgba(0,0,0,0.1);
                                --gradient: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                                --gradient-accent: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
                            }
                            
                            * {
                                margin: 0;
                                padding: 0;
                                box-sizing: border-box;
                            }
                            
                            body {
                                font-family: 'Poppins', sans-serif;
                                background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
                                background-size: 400% 400%;
                                animation: gradientShift 15s ease infinite;
                                color: var(--text);
                                line-height: 1.6;
                                min-height: 100vh;
                                overflow-x: hidden;
                            }
                            
                            @keyframes gradientShift {
                                0% { background-position: 0% 50%; }
                                50% { background-position: 100% 50%; }
                                100% { background-position: 0% 50%; }
                            }
                            
                            .floating-bg {
                                position: fixed;
                                top: 0;
                                left: 0;
                                width: 100%;
                                height: 100%;
                                pointer-events: none;
                                z-index: -1;
                            }
                            
                            .floating-element {
                                position: absolute;
                                background: rgba(255, 255, 255, 0.1);
                                border-radius: 50%;
                                animation: float 6s ease-in-out infinite;
                            }
                            
                            .floating-element:nth-child(1) {
                                width: 80px;
                                height: 80px;
                                top: 20%;
                                left: 10%;
                                animation-delay: 0s;
                            }
                            
                            .floating-element:nth-child(2) {
                                width: 120px;
                                height: 120px;
                                top: 60%;
                                right: 10%;
                                animation-delay: 2s;
                            }
                            
                            .floating-element:nth-child(3) {
                                width: 60px;
                                height: 60px;
                                bottom: 20%;
                                left: 20%;
                                animation-delay: 4s;
                            }
                            
                            @keyframes float {
                                0%, 100% { transform: translateY(0px) rotate(0deg); }
                                50% { transform: translateY(-20px) rotate(180deg); }
                            }
                            
                            .container {
                                max-width: 1200px;
                                margin: 0 auto;
                                padding: 20px;
                            }
                            
                            header {
                                background: rgba(255, 255, 255, 0.95);
                                backdrop-filter: blur(10px);
                                text-align: center;
                                padding: 100px 40px;
                                margin-bottom: 40px;
                                border-radius: 20px;
                                box-shadow: var(--shadow);
                                position: relative;
                                overflow: hidden;
                                transform-style: preserve-3d;
                            }
                            
                            header::before {
                                content: '';
                                position: absolute;
                                top: -50%;
                                left: -50%;
                                width: 200%;
                                height: 200%;
                                background: conic-gradient(from 0deg, transparent, var(--primary), transparent 30%);
                                animation: rotate 10s linear infinite;
                                z-index: 1;
                            }
                            
                            header::after {
                                content: '';
                                position: absolute;
                                inset: 4px;
                                background: white;
                                border-radius: 16px;
                                z-index: 2;
                            }
                            
                            .header-content {
                                position: relative;
                                z-index: 3;
                            }
                            
                            @keyframes rotate {
                                0% { transform: rotate(0deg); }
                                100% { transform: rotate(360deg); }
                            }
                            
                            header h1 {
                                font-size: 4rem;
                                font-weight: 700;
                                margin-bottom: 15px;
                                background: var(--gradient);
                                -webkit-background-clip: text;
                                -webkit-text-fill-color: transparent;
                                background-clip: text;
                                animation: textGlow 2s ease-in-out infinite alternate;
                            }
                            
                            @keyframes textGlow {
                                from { filter: drop-shadow(0 0 10px rgba(102, 126, 234, 0.5)); }
                                to { filter: drop-shadow(0 0 20px rgba(102, 126, 234, 0.8)); }
                            }
                            
                            header .subtitle {
                                font-size: 1.5rem;
                                color: var(--text);
                                font-weight: 300;
                                opacity: 0.9;
                            }
                            
                            .particles {
                                position: absolute;
                                top: 0;
                                left: 0;
                                width: 100%;
                                height: 100%;
                                pointer-events: none;
                                z-index: 4;
                            }
                            
                            .particle {
                                position: absolute;
                                background: var(--gradient-accent);
                                border-radius: 50%;
                                animation: particleFloat 4s ease-in-out infinite;
                            }
                            
                            @keyframes particleFloat {
                                0%, 100% { transform: translate(0, 0) scale(0); opacity: 0; }
                                50% { transform: translate(var(--tx, 100px), var(--ty, -100px)) scale(1); opacity: 1; }
                            }
                            
                            section {
                                background: rgba(255, 255, 255, 0.95);
                                backdrop-filter: blur(10px);
                                margin: 40px 0;
                                padding: 50px;
                                border-radius: 20px;
                                box-shadow: var(--shadow);
                                transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
                                opacity: 0;
                                transform: translateY(50px);
                                border: 1px solid rgba(255, 255, 255, 0.2);
                            }
                            
                            section.visible {
                                opacity: 1;
                                transform: translateY(0);
                            }
                            
                            section:hover {
                                transform: translateY(-10px) scale(1.02);
                                box-shadow: 0 30px 60px rgba(0,0,0,0.2);
                            }
                            
                            h2 {
                                color: var(--primary);
                                font-size: 2.5rem;
                                margin-bottom: 30px;
                                padding-bottom: 15px;
                                position: relative;
                                display: inline-block;
                            }
                            
                            h2::before {
                                content: '';
                                position: absolute;
                                bottom: 0;
                                left: 0;
                                width: 0;
                                height: 4px;
                                background: var(--gradient-accent);
                                border-radius: 2px;
                                transition: width 0.8s ease;
                            }
                            
                            section:hover h2::before {
                                width: 100%;
                            }
                            
                            .about p {
                                font-size: 1.2rem;
                                line-height: 1.8;
                                color: var(--text);
                                text-align: justify;
                            }
                            
                            .skills-grid {
                                display: grid;
                                grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
                                gap: 20px;
                                list-style: none;
                            }
                            
                            .skill-item {
                                background: linear-gradient(135deg, var(--light), #e2e8f0);
                                padding: 25px;
                                border-radius: 15px;
                                border-left: 5px solid var(--primary);
                                transition: all 0.4s ease;
                                position: relative;
                                overflow: hidden;
                            }
                            
                            .skill-item::before {
                                content: '';
                                position: absolute;
                                top: 0;
                                left: -100%;
                                width: 100%;
                                height: 100%;
                                background: var(--gradient);
                                transition: left 0.4s ease;
                                z-index: 1;
                            }
                            
                            .skill-item:hover::before {
                                left: 0;
                            }
                            
                            .skill-item span {
                                position: relative;
                                z-index: 2;
                                font-weight: 600;
                                transition: color 0.4s ease;
                            }
                            
                            .skill-item:hover span {
                                color: white;
                            }
                            
                            .skill-icon {
                                margin-right: 15px;
                                font-size: 1.2rem;
                                color: var(--primary);
                                transition: all 0.4s ease;
                            }
                            
                            .skill-item:hover .skill-icon {
                                color: white;
                                transform: scale(1.2) rotate(360deg);
                            }
                            
                            .projects-grid {
                                display: grid;
                                grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
                                gap: 25px;
                                list-style: none;
                            }
                            
                            .project-item {
                                background: var(--light);
                                padding: 30px;
                                border-radius: 15px;
                                border: 2px solid transparent;
                                transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
                                position: relative;
                                overflow: hidden;
                            }
                            
                            .project-item::before {
                                content: '';
                                position: absolute;
                                top: 0;
                                left: 0;
                                width: 100%;
                                height: 5px;
                                background: var(--gradient);
                                transform: scaleX(0);
                                transition: transform 0.4s ease;
                            }
                            
                            .project-item:hover::before {
                                transform: scaleX(1);
                            }
                            
                            .project-item:hover {
                                background: white;
                                border-color: var(--primary);
                                transform: translateY(-10px) scale(1.05);
                                box-shadow: 0 20px 40px rgba(0,0,0,0.15);
                            }
                            
                            .project-icon {
                                font-size: 2rem;
                                color: var(--primary);
                                margin-bottom: 15px;
                                transition: all 0.4s ease;
                            }
                            
                            .project-item:hover .project-icon {
                                transform: scale(1.2) rotate(10deg);
                                color: var(--secondary);
                            }
                            
                            .contact {
                                background: rgba(45, 55, 72, 0.95);
                                backdrop-filter: blur(10px);
                                color: white;
                                text-align: center;
                            }
                            
                            .contact h2 {
                                color: white;
                            }
                            
                            .contact-info {
                                display: grid;
                                grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                                gap: 30px;
                                margin-top: 30px;
                            }
                            
                            .contact-item {
                                padding: 25px;
                                background: rgba(255, 255, 255, 0.1);
                                border-radius: 15px;
                                transition: all 0.4s ease;
                                border: 1px solid transparent;
                            }
                            
                            .contact-item:hover {
                                background: rgba(255, 255, 255, 0.2);
                                border-color: var(--accent);
                                transform: translateY(-5px) scale(1.05);
                            }
                            
                            .contact-icon {
                                font-size: 2.5rem;
                                margin-bottom: 15px;
                                color: var(--accent);
                                transition: all 0.4s ease;
                            }
                            
                            .contact-item:hover .contact-icon {
                                transform: scale(1.3) rotate(360deg);
                                color: #f093fb;
                            }
                            
                            .contact-text {
                                font-size: 1.1rem;
                                font-weight: 500;
                            }
                            
                            @media (max-width: 768px) {
                                header h1 {
                                    font-size: 2.5rem;
                                }
                                
                                header .subtitle {
                                    font-size: 1.2rem;
                                }
                                
                                section {
                                    padding: 30px;
                                    margin: 25px 0;
                                }
                                
                                .container {
                                    padding: 15px;
                                }
                                
                                .skills-grid,
                                .projects-grid {
                                    grid-template-columns: 1fr;
                                }
                                
                                .contact-info {
                                    grid-template-columns: 1fr;
                                }
                            }
                            
                            /* Scroll animations */
                            @keyframes slideInUp {
                                from {
                                    opacity: 0;
                                    transform: translateY(50px);
                                }
                                to {
                                    opacity: 1;
                                    transform: translateY(0);
                                }
                            }
                            
                            /* Cursor animation */
                            .cursor-follower {
                                position: fixed;
                                width: 20px;
                                height: 20px;
                                background: var(--gradient-accent);
                                border-radius: 50%;
                                pointer-events: none;
                                z-index: 9999;
                                mix-blend-mode: difference;
                                transition: transform 0.1s ease;
                            }
                            
                            /* Loading animation */
                            .loader {
                                position: fixed;
                                top: 0;
                                left: 0;
                                width: 100%;
                                height: 100%;
                                background: var(--gradient);
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                z-index: 9999;
                                transition: opacity 0.5s ease;
                            }
                            
                            .spinner {
                                width: 50px;
                                height: 50px;
                                border: 5px solid rgba(255,255,255,0.3);
                                border-top: 5px solid white;
                                border-radius: 50%;
                                animation: spin 1s linear infinite;
                            }
                            
                            @keyframes spin {
                                0% { transform: rotate(0deg); }
                                100% { transform: rotate(360deg); }
                            }
                        </style>
                    </head>
                    <body>
                        <div class="floating-bg">
                            <div class="floating-element"></div>
                            <div class="floating-element"></div>
                            <div class="floating-element"></div>
                        </div>
                        
                        <div class="cursor-follower"></div>
                        
                        <div class="loader">
                            <div class="spinner"></div>
                        </div>
                        
                        <div class="container">
                    """);

            // HEADER
            bw.write("<header>");
            bw.write("<div class=\"particles\" id=\"headerParticles\"></div>");
            bw.write("<div class=\"header-content\">");
            bw.write("<h1>" + data.getName() + "</h1>");
            bw.write("<div class=\"subtitle\">Creative Professional Portfolio</div>");
            bw.write("</div></header>");

            // ABOUT SECTION
            bw.write("""
                    <section class="about">
                        <h2><i class="fas fa-user"></i> About Me</h2>
                        <p>
                    """);

            bw.write(data.getAbout());

            bw.write("""
                        </p>
                    </section>
                    """);

            // SKILLS SECTION
            bw.write("<section class=\"skills\"><h2><i class=\"fas fa-code\"></i> Skills</h2><ul class=\"skills-grid\">");
            String[] skillIcons = {"fab fa-js", "fab fa-java", "fab fa-python", "fab fa-html5", "fab fa-css3", "fab fa-react", "fas fa-database", "fas fa-cloud"};
            int iconIndex = 0;
            for (String s : data.getSkills()) {
                String icon = iconIndex < skillIcons.length ? skillIcons[iconIndex] : "fas fa-star";
                bw.write("<li class=\"skill-item\"><i class=\"" + icon + " skill-icon\"></i><span>" + s.trim() + "</span></li>");
                iconIndex = (iconIndex + 1) % skillIcons.length;
            }
            bw.write("</ul></section>");

            // PROJECTS SECTION
            bw.write("<section class=\"projects\"><h2><i class=\"fas fa-project-diagram\"></i> Projects</h2><ul class=\"projects-grid\">");
            String[] projectIcons = {"fas fa-laptop-code", "fas fa-mobile-alt", "fas fa-globe", "fas fa-robot", "fas fa-chart-line", "fas fa-gamepad"};
            iconIndex = 0;
            for (String p : data.getProjects()) {
                String icon = iconIndex < projectIcons.length ? projectIcons[iconIndex] : "fas fa-rocket";
                bw.write("<li class=\"project-item\"><i class=\"" + icon + " project-icon\"></i><div class=\"project-text\">" + p.trim() + "</div></li>");
                iconIndex = (iconIndex + 1) % projectIcons.length;
            }
            bw.write("</ul></section>");

            // CONTACT SECTION
            bw.write("""
                    <section class="contact">
                        <h2><i class="fas fa-envelope"></i> Contact</h2>
                        <div class="contact-info">
                    """);

            bw.write("<div class=\"contact-item\"><i class=\"fas fa-envelope contact-icon\"></i><div class=\"contact-text\">" + data.getEmail() + "</div></div>");
            bw.write("<div class=\"contact-item\"><i class=\"fas fa-phone contact-icon\"></i><div class=\"contact-text\">" + data.getPhone() + "</div></div>");

            bw.write("""
                        </div>
                    </section>
                    </div>
                    
                    <script>
                        // Loading animation
                        window.addEventListener('load', function() {
                            setTimeout(() => {
                                document.querySelector('.loader').style.opacity = '0';
                                setTimeout(() => {
                                    document.querySelector('.loader').style.display = 'none';
                                }, 500);
                            }, 1000);
                        });
                        
                        // Scroll animations
                        const observerOptions = {
                            threshold: 0.1,
                            rootMargin: '0px 0px -50px 0px'
                        };
                        
                        const observer = new IntersectionObserver((entries) => {
                            entries.forEach(entry => {
                                if (entry.isIntersecting) {
                                    entry.target.classList.add('visible');
                                }
                            });
                        }, observerOptions);
                        
                        document.querySelectorAll('section').forEach(section => {
                            observer.observe(section);
                        });
                        
                        // Cursor follower
                        const cursor = document.querySelector('.cursor-follower');
                        document.addEventListener('mousemove', (e) => {
                            cursor.style.left = e.clientX + 'px';
                            cursor.style.top = e.clientY + 'px';
                        });
                        
                        // Header particles
                        function createParticles() {
                            const container = document.getElementById('headerParticles');
                            for (let i = 0; i < 15; i++) {
                                const particle = document.createElement('div');
                                particle.className = 'particle';
                                particle.style.setProperty('--tx', (Math.random() * 200 - 100) + 'px');
                                particle.style.setProperty('--ty', (Math.random() * 200 - 100) + 'px');
                                particle.style.left = Math.random() * 100 + '%';
                                particle.style.top = Math.random() * 100 + '%';
                                particle.style.width = Math.random() * 10 + 5 + 'px';
                                particle.style.height = particle.style.width;
                                particle.style.animationDelay = Math.random() * 4 + 's';
                                container.appendChild(particle);
                            }
                        }
                        
                        createParticles();
                        
                        // Interactive hover effects
                        document.querySelectorAll('.skill-item, .project-item, .contact-item').forEach(item => {
                            item.addEventListener('mouseenter', function() {
                                this.style.transform = 'translateY(-10px) scale(1.05)';
                            });
                            
                            item.addEventListener('mouseleave', function() {
                                this.style.transform = 'translateY(0) scale(1)';
                            });
                        });
                    </script>
                    </body>
                    </html>
                    """);

        } catch (IOException e) {
            System.out.println("Error generating portfolio: " + e.getMessage());
        }
    }

    public void open(String fileName) {
        try {
            File f = new File(fileName);
            if (f.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(f.toURI());
                System.out.println("Portfolio opened in browser!");
            } else {
                System.out.println("Couldn't open the browser automatically.");
            }
        } catch (Exception e) {
            System.out.println("Browser open error: " + e.getMessage());
        }
    }
}