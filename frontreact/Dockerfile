# Use an official Node.js image as the base image
FROM node:18.12.0-alpine

# Set the working directory inside the container
WORKDIR /app
# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the rest of the application code to the container
COPY . .

# Build the React app
RUN npm run build

# Expose the port your React app is running on
EXPOSE 3000

# Command to start the React app when the container starts
CMD ["npm", "run", "dev"]