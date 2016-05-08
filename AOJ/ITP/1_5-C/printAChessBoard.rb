while true
  args = STDIN.gets().chomp!.split(/\s/)
  h = args[0].to_i; w = args[1].to_i
  if h == 0 && w == 0
    exit
  end
  dot = false
  for i in 0...h
    is = dot
    for j in 0...w
      if is
        print '.'
      else
        print '#'
      end
      is = !is
    end
    puts
    dot = !dot
  end
  puts
end
