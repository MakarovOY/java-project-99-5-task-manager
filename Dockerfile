FROM gradle:8.5.0-jdk21


WORKDIR /

COPY /src src

ENV JAVA_OPTS "-Xmx512M -Xms512M"

COPY / .

RUN gradle installDist

CMD ./build/install/app/bin/app