FROM gradle:8.5.0-jdk21


WORKDIR /

COPY /src src

COPY / .

RUN gradle installDist

CMD ./build/install/app/bin/app
