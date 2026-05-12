# Assignment 4: Graph Traversal and Representation System

## A. Project Overview
This project implements a graph management system in Java to demonstrate core concepts of discrete structures and algorithm analysis.

* **Graph Structure**: A collection of nodes (vertices) connected by paths (edges).
* **Representation**: The graph uses an **Adjacency List** for memory-efficient storage.
* **Traversal**: Implementation of two fundamental algorithms, **BFS** and **DFS**, to explore the graph nodes.

## B. Class Descriptions
The project is organized into five core Java classes to ensure clean and maintainable code:

* **Vertex.java**: Represents a node using a unique `id` field.
* **Edge.java**: Represents the connection between a `source` and a `destination` vertex.
* **Graph.java**: Handles the adjacency list logic, including adding vertices and edges, and executing BFS/DFS.
* **Experiment.java**: Manages the performance testing by measuring execution time for different graph sizes.
* **Main.java**: The entry point that initializes the graphs and triggers the experimental runs.

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
* **Step-by-step**: BFS explores the graph layer by layer. It uses a **Queue** (FIFO) to visit all immediate neighbors of a node before moving to the next level.
* **Use cases**: Finding the shortest path in unweighted graphs and peer-to-peer network broadcasting.
* **Time complexity**: O(V + E).

### 2. Depth-First Search (DFS)
* **Step-by-step**: DFS explores as far as possible along a branch before backtracking. It is implemented using **Recursion** or a stack.
* **Use cases**: Topological sorting, detecting cycles in a graph, and solving puzzles like mazes.
* **Time complexity**: O(V + E).

## D. Experimental Results
The algorithms were tested on three graph sizes to analyze performance scaling.

| Graph Size | BFS Execution Time (ns) | DFS Execution Time (ns) |
| :--- |:------------------------| :--- |
| **10 Vertices** | *2150000*                      | *743300* |
| **30 Vertices** | *2695600*         | *1105900* |
| **100 Vertices** | *4270500*         | *5767800* |

### Observations and Patterns
* **Complexity**: Results generally align with O(V + E), showing a linear increase in time as the number of vertices and edges grows.
* **Speed**: One algorithm may appear faster depending on the specific structure (directed/undirected) or the density of the edges.

## E. Screenshots
* **Graph Structure Output**: *![img_1.png](img_1.png)*
* **BFS Traversal Output**: *![img_2.png](img_2.png)*
* **DFS Traversal Output**: *![img_3.png](img_3.png)*
* **Performance Results**: *![img_4.png](img_4.png)*

## F. Reflection Section
During this assignment, I learned how graph representation impacts the efficiency of traversal. The primary difference discovered is that BFS is optimal for finding the shortest distance, while DFS is better for exploring deep structures.

One of the main challenges was managing the `nanoTime()` measurements accurately to ensure the overhead did not skew the results. Additionally, implementing the adjacency list using a Map structure provided a flexible way to handle graphs of varying sizes.