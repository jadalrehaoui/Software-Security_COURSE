# Software-Security_COURSE
Taken @SNHU with Dr. Vivian Lyon


# Client => Artemis Financial
Artemis Financial a consulting company that develops individualized financial plans for their customers. The financial plans include savings, retirement,
investments, and insurance. They want to modernize their operations. As a crucial part of the success of their custom software, they also want to use the
most current and effective software security. Artemis Financial has a RESTful web application programming interface (API). They are seeking Global Rain’s
expertise about how to protect the organization from external threats.

# Implementation
First, I generated a self signed certificate and deployed it to the server to ensure that the communication between the client and the server is secure 
and safe. I have do so by using the the `keytool.exe`

**I have used the following commands to generate and export the certificate**

`"C:\Program Files\Java\jdk-19\bin\keytool.exe" -genkey -keyalg RSA -alias <your-cert-alias-name> -keypass <you-password> -keystore keystore.jks -storepass <your-password> -validity 360 -keysize 2048`

`"C:\Program Files\Java\jdk-19\bin\keytool.exe" -export -alias selfsigned -storepass <your-password> -file <certificate-name.cer> -keystore keystore.jks`

`"C:\Program Files\Java\jdk-19\bin\keytool.exe" -printcert -file <certificate-name.cer>`

`"C:\Program Files\Java\jdk-19\bin\keytool.exe" -export -alias <your-cert-alias-name> -storepass <your-password> -file <your-cert-alias-name> -keystore keystore.jks`

Then I navigated to `Manage Computer Certificates` in windows to trust this certificate and added it to the trusted ones.

Now that this certificate is trusted by my PC I can run the server and access the routes on HTTPS. 

Then comes the part where I found it interesting and helpful for later projects, implementing the checksum using SHA-512/244
*Refer to the code in the sslServerApplication*

I increased the layers of security by first applying the SSL certificate to the server, then adding a checksum to the requests to be hashed before they 
are sent to the client. This ensures integrity and confidentiality between the client and the server.

The code of this application runs perfectly when launching the server and we can see that when we access the route https://localhost8443/hash

I also used the OWASP dependency check plugin in this application to make sure all the dependencies I am using are safe and secure of any high risk vulnerability.

For the future, I would implement the OAuth 2.0 industry standard protocol to make sure that all the request are coming from my front end application to 
the server and no other device or software can access the routes and data coming from or going to the server.

Thanks to Dr. Lyon for the help she provided and for SNHU.




