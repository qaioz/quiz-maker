FROM node:14 AS build

WORKDIR /app

COPY package*.json ./
COPY tailwind.config.js ./
COPY README.md ./
COPY ./src ./src
COPY ./public ./public

RUN npm install

CMD ["npm", "start"]
