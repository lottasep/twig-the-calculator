# Calculator application

This is a project for the Twig The Code codecamp 2024! 
The repository offers the skeleton, and some tasks how to make the calculator better! :) 


## How to get started?

1. Make sure you have the following installed:

- JDK 1.7 or newer, please have a newer
- Leiningen (https://leiningen.org/)

2. Clone this repository.


## Development mode

Run  `npm install` and  `npx shadow-cljs watch app`

Then connect your IDE to the ClojureScript REPL.


## Documentation

This repository has a few docs to help you onward:

1. The very basics of Clojure syntax. Mostly ripped from ClojureBridge (FI) documentation, this file is a good place to start: [basics.clj](basics.clj)

2. A list of work to do! Of course you don't need to follow this at all, you can just go and create your own flow. But this might be useful ;-) [TODO.md](TODO.md)

3. A helper namespace. Here I have tried to gather all the "calculator-specific" funtions and things, that aren't covered anywhere else: [helper.cljs](helper.cljs)

4. Finally, links. Here you can find more info about Clojure, where to learn more and where to meet like-minded Clojurist :-) Some links are useful with this project too! [links.md](links.md)

##

### Somewhat irrelevant image of explaining sequence transformations with Pokémon ;-D

![map-filter-pikachu-image](/map-filter-pikapika.png)

## Building for production if you decide to go that far with this

```
npx shadow-cljs release app
```
