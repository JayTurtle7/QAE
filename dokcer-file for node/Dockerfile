FROM node:9

# Create app directory
RUN mkdir -p /app
# Add package-lock.json and package.json
ADD package* /app/
# switch working dir to app
WORKDIR /app
# install dependencies
RUN npm install
# Copy source code into app folder
ADD ./src src


EXPOSE 3000
CMD [ "npm", "start" ]