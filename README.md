# Master thesis document

---

1. Introduction: scope and objectives, thesis structure overview

2. Background

   1. The role of portability in software engineering (what is portability, primary challenges and how it affects the software lifecycle)
   2. Language interoperability (why making the API of a software product interoperable with other languages?)
   3. Approaches to multi-platform and polyglottism
      1. The case of Scala
         1. Scala JS
         2. Scala Native

3. Context and motivations

   1. Aggregate computing: a bird's eye view
      1. Why portability and interoperability matter in Aggregate Computing
   2. ScaFi3 overview: a Scala 3 library for aggregate computing

4. Contribution

   1. Proposed architecture
   2. Abstract design
      1. Support for a cross-platform and polyglot serialization binding
      2. Design of a portable module for distribution

5. Implementation

6. Validation

   1. Integration testing
   2. Demonstration

7. Conclusion and future works

---

possible title: Toward Portable and Interoperable Aggregate Computing Systems

- in 3.1 explain current limitations
- in 3.1 explain general principles to apply during development of a cross-platform library

---

1. Introduction
2. Context and Motivations
   1. The centrality role of portability: os -> C compiled code -> java byte code to be "run everywhere"
   2. Why caring other platforms and the role of modern programming languages targeting different platforms
      1. The impact in terms of programming: addressing the abstraction gap — https://unibo-spe.github.io/12-multiplatform/#/16
   3. Why caring about making the API of a software product interoperate with other languages?
      1. Different languages, different runtimes and different **ecosystems** — https://unibo-spe.github.io/12-multiplatform/#/11 — https://unibo-spe.github.io/12-multiplatform/#/6
      2. The opposite approach: calling from the "super" language libraries from other languages (e.g. Scala <- Python libraries)
      3. Why choosing a language as a reference? The role of abstraction in software engineering
3. State of the art:
   1. How kotlin and scala deal with portability and abstraction gap
   2. The approach of Cazzola et. al (not consider multi-target language like kotlin and scala)
   3. Spark architecture?
   4. Why caring for aggregate computing. Btw, what is Aggregate Computing?

## References

- [Here](./notes/notes.md) you can find a collection of random notes which can be useful.
- [Scrivere una tesi di laurea in LaTex](http://profs.scienze.univr.it/~gregorio/mori.pdf)
- [Alcune regole per lo svolgimento della tesi](https://www.moreno.marzolla.name/wiki/doku.php?id=tesi:suggerimenti)
