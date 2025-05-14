# Notes in random order

- to set, for a document section, a different margin size:
  ```tex
  \newgeometry{margin=2cm}
  ...
  \restoregeometry
  ```

- if you want to set each margin 2cm without header space, what you need is just 
    ```tex
    \usepackage[margin=2cm,nohead]{geometry}.
    ```

-  to reference equations:
    ```tex
    \begin{equation[*]}
    ```
    where `[*]` is optional (for not numbering them)

-  When you want increase the width of an image beyond page margins, centering it, use:
    ```tex
    \begin{figure}[h!]
        \makebox[\textwidth][c]{
            \includegraphics[width=1.15\textwidth]{resources/img/02-achitecture.pdf}
        }
        \caption{Schema UML architetturale del sistema.}
        \label{img:02-architecture}
    \end{figure}
    ```

- If you want to display an image horizontally:
    ```tex
    \begin{sidewaysfigure}
        \hspace*{-1.2cm}
        \centering
        \includegraphics[width=1.22\textwidth]{resources/img/02-detector.pdf}
        \hspace*{1cm}
        \caption{Schema UML del \textit{detector}.}
        \label{img:02-detector}
    \end{sidewaysfigure}
    ```
    Of course you can use `makebox` inside `sidewaysfigure`:
    ```tex
    \begin{sidewaysfigure}
        \hspace*{-1.2cm}
        \makebox[\textwidth][c]{
            \includegraphics[width=1.22\textwidth]{resources/img/02-detector.pdf}
        }
        \hspace*{1cm}
        \caption{Schema UML del \textit{detector}.}
        \label{img:02-detector}
    \end{sidewaysfigure}
    ```

- [tutorial for multi-column and multi-row cells in tables](https://texblog.org/2012/12/21/multi-column-and-multi-row-cells-in-latex-tables/)

- [tutorial for math graphs in latex](https://it.overleaf.com/learn/latex/Pgfplots_package)