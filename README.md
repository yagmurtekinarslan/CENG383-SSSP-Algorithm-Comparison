# CENG383 - Single-Source Shortest Path Algorithm Comparison

## Overview
This project implements and compares two Single-Source Shortest Path (SSSP) algorithms: Dijkstra's Algorithm and Bellman-Ford Algorithm, tested on real US road networks from the DIMACS 9th Implementation Challenge dataset. Runtime, memory usage, and scalability were measured and compared across three datasets of increasing size.

## Algorithms
| Algorithm | Time Complexity | Space Complexity |
|-----------|----------------|-----------------|
| Dijkstra | O((V + E) log V) | O(V) |
| Bellman-Ford | O(V × E) | O(V) |

## Dataset
DIMACS 9th Implementation Challenge Road Networks
- NY (New York): 264,346 nodes, 733,846 edges
- COL (Colorado): 435,666 nodes, 1,057,066 edges
- FLA (Florida): 1,070,376 nodes, 2,712,798 edges

Source: https://www.diag.uniroma1.it/challenge9/download.shtml

## Project Structure
CENG383-Assignment/
- src/ - Java source files
- data/ - DIMACS dataset files
- results/ - Output graphs and charts

## Results
| Dataset | Dijkstra Time | Bellman-Ford Time | Dijkstra RAM | Bellman-Ford RAM |
|---------|--------------|-------------------|--------------|-----------------|
| NY | 61 ms | 1848 ms | 22 MB | 5 MB |
| COL | 87 ms | 3380 ms | 32 MB | 5 MB |
| FLA | 186 ms | 15808 ms | 79 MB | 11 MB |

## How to Run
1. Download dataset files from DIMACS and place them in data/ folder
2. Open project in IntelliJ IDEA
3. Change filePath in Main.java to desired dataset
4. Run Main.java

## Requirements
- Java JDK 17+
- IntelliJ IDEA
