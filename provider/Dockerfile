FROM java:8

#工作路径
ENV WORK_PATH "/home"
ARG JAR_FILE="./target/*-SNAPSHOT.jar"
ARG SERVER_PORT=9001

#dubbo注册中心地址
ARG DUBBO_ADDRESS="nacos://local143:8848"


# 内存配置
ENV JAVA_OPTS "-Xmx256m"


#日志路径
ENV LOG_FILE "logs/app.log"
#服务端口
ENV SERVER_PORT $SERVER_PORT

#设置时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

VOLUME /tmp

EXPOSE ${SERVER_PORT}


COPY ${JAR_FILE} ${WORK_PATH}/app.jar

ADD  $DOWNLOAD_URL/$LICENSE_NAME ${WORK_PATH}

RUN sh -c 'touch ${WORK_PATH}/app.jar'

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS $AGENT_OPS -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom  -Ddubbo.registry.address=$DUBBO_ADDRESS -Dserver.port=$SERVER_PORT  -Duser.timezone=GMT+08 -jar $WORK_PATH/app.jar " ]