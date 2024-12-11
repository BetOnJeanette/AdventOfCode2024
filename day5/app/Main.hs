module Main where

import Part1
import System.IO
import Control.Monad 
import Data.List.Split
import Data.HashSet as HashSet hiding (foldl, fold, map, filter)

failPoint :: [(String, HashSet String)] -> [Bool]
failPoint zippedArr = map (\(item, dep) -> not (HashSet.member item dep)) zippedArr

main = do
    contents <- readFile "input.txt"
    let (deps:input) = splitWhen (\line -> length line == 0) (lines contents)
    let updates = head input
    let sol1 = Part1.solvePart1 deps updates
    print (show sol1)
