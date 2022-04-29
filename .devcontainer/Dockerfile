FROM gitpod/workspace-full

ARG JDK_VERSION="17.0.2.fx-zulu"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install java ${JDK_VERSION}"

# [Option] Install Maven
ARG INSTALL_MAVEN="false"
ARG MAVEN_VERSION=""

# [Option] Install Gradle
ARG INSTALL_GRADLE="false"
ARG GRADLE_VERSION=""

RUN if [ "${INSTALL_MAVEN}" = "true" ]; then bash -c "umask 0002 && . /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; fi \
    && if [ "${INSTALL_GRADLE}" = "true" ]; then bash -c "umask 0002 && . /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk install gradle \"${GRADLE_VERSION}\""; fi

RUN sudo usermod -p "" gitpod
USER gitpod