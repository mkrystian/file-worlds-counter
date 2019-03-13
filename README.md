**File words counter**

To start app JDK8 or newer is required

Before start build app:
mvnw clean compile assembly:single

And start app in ./target directory:
java -jar file-worlds-counter-1.0-jar-with-dependencies.jar _directoryToScan_