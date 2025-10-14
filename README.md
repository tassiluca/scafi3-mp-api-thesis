# Master thesis document

```

1. Introduction

2. Background

   2.1. The role of portability in software engineering
   2.2. Language interoperability
   2.3. Approaches to multi-platform and polyglotism
      2.3.1. The case of Scala

3. Context and motivations

   3.1. Aggregate computing: a bird's eye view
      3.1.1. Why portability and interoperability matter in Aggregate Computing
   3.2. ScaFi3 overview: a Scala 3 library for aggregate programming

4. Contribution

   4.1. Proposed architecture
   4.2. Design
      4.2.1. Support for a general cross-platform and polyglot serialization binding
      4.2.2. Cross-platform distribution module
      4.2.3. Cross-platform and polyglot library abstraction layer

5. Implementation details
   5.1. Modules implementation
      5.1.1. Protobuf serialization binding
      5.1.2. Socket-based distributed network
      5.1.3. Platform-specific library abstraction layers
   5.2. Implementation challenges

6. Validation

   6.1. Integration testing
   6.2. Demonstration

7. Conclusions and future works

```

possible title: Toward Portable and Interoperable Aggregate Computing Systems

- in implementation: technology used
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
