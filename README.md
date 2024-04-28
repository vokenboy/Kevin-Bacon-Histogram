# Java Bacon Number Finder

## Overview

This Java application is a fun, educational project developed as part of university coursework. It explores the "six degrees of separation" concept, famously linked to actor Kevin Bacon. Users can input the name of a movie database and interactively search for the "Bacon number" of various actors, where a Bacon number is the distance through shared film roles to Kevin Bacon himself.

This project utilizes graph data structures to map relationships between actors and uses breadth-first search (BFS) to calculate distances within this network.

## Features

- **File Reading:** Imports a user-specified movie database to construct the graph.
- **Graph Building:** Builds a graph where vertices represent actors and edges denote co-appearances in films.
- **Bacon Number Calculation:** Calculates the shortest path from Kevin Bacon to other actors, determining the Bacon number.
- **Interactive Interface:** Users can input actor names interactively to receive their corresponding Bacon numbers.
- **Bacon Histogram:** Generates a histogram of Bacon numbers across the dataset to illustrate connectivity patterns within Hollywood.

## Project Structure

The project is organized into several packages, each handling a specific aspect of the application:

- `main.java.demo`:
  - **Main.java** - The entry point of the application, managing file input and user interactions.
- `main.java.utils`:
  - **FileReader.java** - Reads and processes the movie database file.
  - **Graph.java** - Implements the graph data structure for storing actor and movie relationships.
  - **PathFinder.java** - Provides the BFS algorithm for finding the shortest path in the graph.
  - **BaconHistogram.java** - Produces a histogram of Bacon numbers.
  - **Queue.java** and **ListQueue.java** - Implements a queue used in the BFS algorithm.

## How to Run

1. **Compile the Project**:
   Ensure Java is installed and your CLASSPATH environment variable is set appropriately. Navigate to the project's root directory and compile the Java files:
   ```bash
   javac main/java/**/*.java
2. Run the Application:
Start the application by running:
   ``` bash
   java main.java.demo.Main
