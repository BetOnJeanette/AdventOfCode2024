module Part1 where

import Data.HashMap.Strict as HashMap hiding (foldl, fold, map, filter)
import Data.HashSet as HashSet hiding (foldl, fold, map, filter)
import Data.List.Split
import Data.List ( mapAccumL )

buildSingleDepMap :: String -> HashMap String (HashSet String)
buildSingleDepMap depItem = HashMap.singleton (head depends) (HashSet.singleton depender)
    where (depender:depends) = splitOn "|" depItem

combineDeps :: HashMap String (HashSet String) -> HashMap String (HashSet String) -> HashMap String (HashSet String)
combineDeps acc new = HashMap.unionWith (\accSet newSet -> HashSet.union accSet newSet) acc new

buildFullDepMap :: [String] -> HashMap String (HashSet String)
buildFullDepMap deps = foldl combineDeps HashMap.empty (map buildSingleDepMap deps)

usedDeps :: [String] -> HashMap String (HashSet String) -> [HashSet String]
usedDeps updates depMap = (tail list) ++ [final]
    where 
        (final,list) = mapAccumL combineSets HashSet.empty updates
        combineSets accum item = (HashSet.union accum (findWithDefault HashSet.empty item depMap), accum)

isValidUpdate :: [String] -> HashMap String (HashSet String) -> Bool
isValidUpdate update depMap = all (\(item,dep) -> not (HashSet.member item dep)) combined
    where combined = zip update (usedDeps update depMap)

reverseList :: [a] -> [a]
reverseList [] = []
reverseList (x:xs) = reverseList xs ++ [x]

moveToMiddle :: Eq a => [a] -> [a] -> a
moveToMiddle (left: originalList) (right: revList) = 
    if left==right 
    then left
    else moveToMiddle originalList revList

getMiddleItem :: [String] -> Integer
getMiddleItem update = read midItem :: Integer
    where midItem = moveToMiddle update (reverseList update)

solvePart1 :: [String] -> [String] -> Integer
solvePart1 deps updates = sum (map (\update -> getMiddleItem update) validUpdates)
    where 
        validUpdates = filter (\update -> isValidUpdate update (buildFullDepMap deps)) commaSplitUpdates 
        commaSplitUpdates = map (\update -> splitOn "," update) updates
