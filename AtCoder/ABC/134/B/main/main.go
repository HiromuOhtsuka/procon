package main

import (
  "fmt"
)

func main() {
  var n, d int
  fmt.Scan(&n)
  fmt.Scan(&d)
  var ans int
  if n % (2 * d + 1) == 0 {
    ans = n / (2 * d + 1)
  } else {
    ans = n / (2 * d + 1) + 1
  }
  fmt.Println(ans)
}
